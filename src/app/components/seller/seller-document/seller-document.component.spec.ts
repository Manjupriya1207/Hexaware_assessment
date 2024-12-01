import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerDocumentComponent } from './seller-document.component';

describe('SellerDocumentComponent', () => {
  let component: SellerDocumentComponent;
  let fixture: ComponentFixture<SellerDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SellerDocumentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellerDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
