import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManejoSanitarioComponent } from './manejo-sanitario.component';

describe('ManejoSanitarioComponent', () => {
  let component: ManejoSanitarioComponent;
  let fixture: ComponentFixture<ManejoSanitarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManejoSanitarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManejoSanitarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
