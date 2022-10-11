import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBookbyEmailandPaymentIdComponent } from './search-bookby-emailand-payment-id.component';

describe('SearchBookbyEmailandPaymentIdComponent', () => {
  let component: SearchBookbyEmailandPaymentIdComponent;
  let fixture: ComponentFixture<SearchBookbyEmailandPaymentIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchBookbyEmailandPaymentIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchBookbyEmailandPaymentIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
