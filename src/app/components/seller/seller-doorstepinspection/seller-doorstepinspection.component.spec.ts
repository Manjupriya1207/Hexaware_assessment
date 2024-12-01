import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerDoorstepinspectionComponent } from './seller-doorstepinspection.component';

describe('SellerDoorstepinspectionComponent', () => {
  let component: SellerDoorstepinspectionComponent;
  let fixture: ComponentFixture<SellerDoorstepinspectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SellerDoorstepinspectionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellerDoorstepinspectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
