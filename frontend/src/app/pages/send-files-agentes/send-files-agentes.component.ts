import {Component, EventEmitter, Output} from '@angular/core';
import * as xmljs from 'xml-js';
import {Agente} from "../../models/agente";
import {Regiao} from "../../models/regiao";
import {Compra} from "../../models/children/compra";
import {Geracao} from "../../models/children/geracao";
import {AhoyService} from "../../services/ahoy.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpErrorResponse} from "@angular/common/http";
import {RetornoProcessamento} from "../../models/retorno-processamento";

@Component({
  selector: 'app-send-files-agentes',
  templateUrl: './send-files-agentes.component.html',
  styleUrls: ['./send-files-agentes.component.scss'],
  providers: [AhoyService]
})
export class SendFilesAgentesComponent {

  fileProcess:File | undefined;
  fileInProcess:File [] = [];
  constructor(private ahoyService: AhoyService,
              private snackBar: MatSnackBar) {
  }

  handleFileUpload(file: File) {
    this.fileInProcess = [];
    this.fileInProcess.push(file);
    const reader = new FileReader();

    reader.onload = (event) => {
      const xmlData = event?.target?.result as string;

      const options = {
        compact: true,
      };

      const dadosXML:any = xmljs.xml2js(xmlData, options);
      if (dadosXML && dadosXML?.agentes && dadosXML.agentes.agente) {
        const agentesArray = Array.isArray(dadosXML.agentes)
          ? dadosXML.agentes
          : [dadosXML.agentes];
        let agentes: Agente[] = [];
        this.extractAgente(agentesArray, agentes);

        this.sendAgentes(agentes);
      }

    };

    reader.readAsText(file);

  }


  private extractAgente(agentesArray: Agente[], agentes: Agente[]) {
    agentesArray.map((agenteData: any) => {
      const agenteArrayXML = Array.isArray(agenteData.agente)
        ? agenteData.agente
        : [agenteData.agente];


      return agenteArrayXML.forEach((agenteXML: any) => {
        const agente = new Agente();

        agente.codigo = agenteXML.codigo?._text;
        agente.data = agenteXML.data?._text;
        const regioes: Regiao[] = [];

        agenteXML?.regiao.forEach((regiaoXML: any) => {
          let regiao: Regiao = new Regiao();

          regiao.sigla = regiaoXML._attributes?.sigla;

          regiaoXML.compra?.valor.forEach((compraXML: any) => {
            if (!regiao.compra) regiao.compra = [];
            regiao.compra.push(Number(compraXML._text));
          });
          regiaoXML.geracao?.valor.forEach((geracaoXML: any) => {
            if (!regiao.geracao) regiao.geracao = [];
            regiao.geracao.push(Number(geracaoXML._text));
          });

          regioes.push(regiao);
        });

        agente.regioes = regioes;
        agentes.push(agente);
      });
    });
  }

  private sendAgentes(agentes: Agente[]) {
    this.ahoyService.postAgentes(agentes).subscribe({
      next: ((retorno: RetornoProcessamento) => {
        this.emitirAvisoParaExclusao();

        this.showMessage(" Arquivo: " + this.fileProcess?.name +" "+ retorno.data);
      }),
      error: err => {
        let msg: string = 'Error';
        if (err instanceof HttpErrorResponse) {
          msg = err?.error?.text + ' - ' + err.status;
        }
        this.showMessage(msg);
      }
    })
  }

  private emitirAvisoParaExclusao() {
    this.fileProcess = undefined;
    const file = this.fileInProcess[0];
    const index: number = this.fileInProcess.indexOf(file);
    if (index >= 0 && index < this.fileInProcess.length) {
      this.fileInProcess = this.fileInProcess.slice(index, 1);
    }
    this.fileProcess = this.fileInProcess[0];
  }

  showMessage(msg: string){
    this.snackBar.open(msg, 'Close', {
      duration: 3 * 1000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
    })
  }
}
