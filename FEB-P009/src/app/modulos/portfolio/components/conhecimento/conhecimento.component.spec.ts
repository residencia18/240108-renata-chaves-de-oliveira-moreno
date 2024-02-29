import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConhecimentoComponent } from './conhecimento.component';

describe('ConhecimentoComponent', () => {
  let component: ConhecimentoComponent;
  let fixture: ComponentFixture<ConhecimentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConhecimentoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ConhecimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
