import {Component, ViewChild} from '@angular/core';
import {MatProgressSpinner} from "@angular/material/progress-spinner";
import {LoadingService} from "../../services/loading.service";

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.scss']
})
export class LoadingComponent {
  loading: boolean = false;

  constructor(private loadingService: LoadingService) {
    this.loadingService.isLoading$.subscribe((isLoading) => {
      this.loading = isLoading;
    });
  }

}
