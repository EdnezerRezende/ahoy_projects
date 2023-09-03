import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultRegioesComponent } from './consult-regioes.component';

describe('ConsultRegioesComponent', () => {
  let component: ConsultRegioesComponent;
  let fixture: ComponentFixture<ConsultRegioesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConsultRegioesComponent]
    });
    fixture = TestBed.createComponent(ConsultRegioesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
