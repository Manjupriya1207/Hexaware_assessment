import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OnlineEvaluationPageComponent } from './online-evaluation-page.component';

describe('OnlineEvaluationPageComponent', () => {
  let component: OnlineEvaluationPageComponent;
  let fixture: ComponentFixture<OnlineEvaluationPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OnlineEvaluationPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OnlineEvaluationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
