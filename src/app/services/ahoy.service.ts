import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Agente} from "../models/agente";
import {RetornoProcessamento} from "../models/retorno-processamento";
import {RegiaoConsolidada} from "../models/regiao-consolidada";

@Injectable({
  providedIn: 'root'
})
export class AhoyService {

  private urlAhoy: string = `${environment.ahoyBackend}`;
  constructor(private httpClient: HttpClient) { }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE',
    });
  }

  public postAgentes(agentes: Agente[]): Observable<RetornoProcessamento>{
    return this.httpClient.post<RetornoProcessamento>(`${this.urlAhoy}/agente`, {agentes: agentes}, {headers: this.getHeaders()});
  }

  public getRegioesConsolidadas(): Observable<RetornoProcessamento>{
    return this.httpClient.get<RetornoProcessamento>(`${this.urlAhoy}/regiao/consolidated`, {headers: this.getHeaders()});
  }

}
