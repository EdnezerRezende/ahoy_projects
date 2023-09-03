import {Component, EventEmitter, Input, OnChanges, Output} from '@angular/core';
import {NgxFileDropEntry} from 'ngx-file-drop';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnChanges {
  public filesForSend: File[] = [];
  @Input()
  public fileProcess: File | undefined;

  @Output() fileUploaded:EventEmitter<File> = new EventEmitter<File>();

  ngOnChanges() {
    // Este método será chamado sempre que os dados forem alterados
    this.fileOver(this.fileProcess);
  }

  public dropped(files: NgxFileDropEntry[], index?: any): void {
    // @ts-ignore
    for (const file:NgxFileDropEntry of files) {
      if (file.fileEntry.isFile && file.fileEntry.name.endsWith('.xml')) {
        const fileEntry = file.fileEntry as FileSystemFileEntry;
        fileEntry.file((file: File) => {
          this.filesForSend.push(file);
        });
      }
    }
  }

  public fileOver(fileOut: any){
    this.filesForSend = this.filesForSend.filter(file => file.name != fileOut.name)
  }

  public fileLeave(event: any){
    console.log(event);
  }
  public fileSend(){
    this.filesForSend.forEach(file => {
      this.fileUploaded.emit(file);
    });
  }
}
