// destaque.component.spec.ts
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DestaqueComponent } from './destaque.component';  // Ajuste o caminho conforme necessário

describe('DestaqueComponent', () => {
  let component: DestaqueComponent;
  let fixture: ComponentFixture<DestaqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DestaqueComponent],  // Ajuste para refletir o componente correto
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DestaqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
