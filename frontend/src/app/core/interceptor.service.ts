import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {count, finalize, Observable} from 'rxjs';
import {LoadingService} from "../services/loading.service";

@Injectable({
    providedIn: 'root'
})
export class Interceptor implements HttpInterceptor {
  countRequest: number = 0;
  constructor(private loading: LoadingService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.countRequest++;
    this.loading.showSpinner();
    return next.handle(request).pipe(
      finalize(() => {
        if(this.countRequest <= 1){
          this.loading.hideSpinner();
        }
        this.countRequest--;
      })
    );
  }
}
