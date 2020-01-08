import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioModComponent } from './formulario-mod.component';

describe('FormularioModComponent', () => {
  let component: FormularioModComponent;
  let fixture: ComponentFixture<FormularioModComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormularioModComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioModComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
