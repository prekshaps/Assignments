import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccuracyParametersComponent } from './accuracy-parameters.component';

describe('AccuracyParametersComponent', () => {
  let component: AccuracyParametersComponent;
  let fixture: ComponentFixture<AccuracyParametersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccuracyParametersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccuracyParametersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
