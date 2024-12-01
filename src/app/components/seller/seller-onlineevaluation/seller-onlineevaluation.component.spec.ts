import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerOnlineevaluationComponent } from './seller-onlineevaluation.component';

describe('SellerOnlineevaluationComponent', () => {
  let component: SellerOnlineevaluationComponent;
  let fixture: ComponentFixture<SellerOnlineevaluationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SellerOnlineevaluationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellerOnlineevaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
