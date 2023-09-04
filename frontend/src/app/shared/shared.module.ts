import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {LoadingComponent} from './loading/loading.component';
import {MatCardModule} from "@angular/material/card";
import {NgxFileDropModule} from "ngx-file-drop";
import {UploadComponent} from './upload/upload.component';
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatListModule} from "@angular/material/list";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {LoadingService} from "../services/loading.service";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatMenuModule} from "@angular/material/menu";
import {MatButtonToggleModule} from "@angular/material/button-toggle";


@NgModule({
  declarations: [
    LoadingComponent,
    UploadComponent
  ],
  imports: [
    CommonModule,
    MatSidenavModule,
    MatProgressSpinnerModule,
    MatCardModule,
    NgxFileDropModule,
    MatInputModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatIconModule,
    MatListModule,
    MatSnackBarModule,
    MatGridListModule,
    MatMenuModule,
  ],
  exports: [
    MatSidenavModule,
    MatProgressSpinnerModule,
    MatCardModule,
    NgxFileDropModule,
    MatInputModule,
    MatButtonModule,
    MatButtonToggleModule,
    UploadComponent,
    MatIconModule,
    MatListModule,
    MatSnackBarModule,
    LoadingComponent,
    MatGridListModule,
    MatMenuModule,
  ],
  providers: [LoadingService]
})
export class SharedModule { }
