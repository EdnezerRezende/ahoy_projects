import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../shared/shared.module";
import {HomeComponent} from "./home.component";
import {AppModule} from "../../app.module";
import {SendFilesAgentesComponent} from "../send-files-agentes/send-files-agentes.component";


@NgModule({
  declarations: [
    HomeComponent,
    SendFilesAgentesComponent,

  ],
  imports: [
    CommonModule,
    SharedModule,

  ]
})
export class HomeModule { }
