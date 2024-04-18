import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlePorcosComponent } from './controle-porcos.component';

describe('ControlePorcosComponent', () => {
  let component: ControlePorcosComponent;
  let fixture: ComponentFixture<ControlePorcosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ControlePorcosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ControlePorcosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
