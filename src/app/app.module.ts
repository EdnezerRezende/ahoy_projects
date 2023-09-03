import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {SharedModule} from "./shared/shared.module";
import {HomeModule} from "./pages/home/home.module";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {Interceptor} from "./core/interceptor.service";
import {LoadingService} from "./services/loading.service";
import { ConsultRegioesComponent } from './pages/consult-regioes/consult-regioes.component';

@NgModule({
  declarations: [
    AppComponent,
    ConsultRegioesComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HomeModule,
    HttpClientModule,
    SharedModule,
  ],
  providers: [
    LoadingService,
    {provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true},
  ],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
