import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarGadoComponent } from './editar-gado.component';

describe('EditarGadoComponent', () => {
  let component: EditarGadoComponent;
  let fixture: ComponentFixture<EditarGadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarGadoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditarGadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
