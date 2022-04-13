import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OldcardComponent } from './oldcard.component';

describe('OldcardComponent', () => {
  let component: OldcardComponent;
  let fixture: ComponentFixture<OldcardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OldcardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OldcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
