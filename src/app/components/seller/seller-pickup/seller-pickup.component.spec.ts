import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerPickupComponent } from './seller-pickup.component';

describe('SellerPickupComponent', () => {
  let component: SellerPickupComponent;
  let fixture: ComponentFixture<SellerPickupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SellerPickupComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellerPickupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
