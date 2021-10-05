import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParameterToleranceComponent } from './parameter-tolerance.component';

describe('ParameterToleranceComponent', () => {
  let component: ParameterToleranceComponent;
  let fixture: ComponentFixture<ParameterToleranceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParameterToleranceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParameterToleranceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
