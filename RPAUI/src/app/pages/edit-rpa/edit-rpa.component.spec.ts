import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRpaComponent } from './edit-rpa.component';

describe('EditRpaComponent', () => {
  let component: EditRpaComponent;
  let fixture: ComponentFixture<EditRpaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditRpaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditRpaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
