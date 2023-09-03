import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendFilesAgentesComponent } from './send-files-agentes.component';

describe('SendFilesAgentesComponent', () => {
  let component: SendFilesAgentesComponent;
  let fixture: ComponentFixture<SendFilesAgentesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SendFilesAgentesComponent]
    });
    fixture = TestBed.createComponent(SendFilesAgentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
