import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ListagemSuinosComponent } from './listagem-suinos.component';

describe('ListagemSuinosComponent', () => {
  let component: ListagemSuinosComponent;
  let fixture: ComponentFixture<ListagemSuinosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListagemSuinosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListagemSuinosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  
});
