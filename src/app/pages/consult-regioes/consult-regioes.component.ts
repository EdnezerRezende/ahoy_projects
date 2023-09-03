import {Component, OnInit} from '@angular/core';
import {AhoyService} from "../../services/ahoy.service";
import {RetornoProcessamento} from "../../models/retorno-processamento";
import {RegiaoConsolidada} from "../../models/regiao-consolidada";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-consult-regioes',
  templateUrl: './consult-regioes.component.html',
  styleUrls: ['./consult-regioes.component.scss']
})
export class ConsultRegioesComponent implements OnInit{
  regioesConsolidadas: RegiaoConsolidada[] = [];
  showDados: boolean = false;

  constructor(private ahoyService: AhoyService,
              private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.getRegioesConsolidadas();
  }

  public getRegioesConsolidadas(): void{
    this.ahoyService.getRegioesConsolidadas().subscribe({
      next: (retorno: RetornoProcessamento) => {
        this.regioesConsolidadas = retorno.data;
        if(this.regioesConsolidadas.length > 0) {
          this.showDados = true;
          return;
        }
        this.showMessage("Sem dados para apresentação");

      },
      error: (error: any) => {
        this.showMessage(error.message);
      }
    });
  }

  showMessage(msg: string){
    this.snackBar.open(msg, 'Close', {
      duration: 3 * 1000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
    })
  }
}
