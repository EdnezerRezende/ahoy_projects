import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {SendFilesAgentesComponent} from "./pages/send-files-agentes/send-files-agentes.component";
import {ConsultRegioesComponent} from "./pages/consult-regioes/consult-regioes.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'send-agentes', component: SendFilesAgentesComponent },
  { path: 'consult-regioes', component: ConsultRegioesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
