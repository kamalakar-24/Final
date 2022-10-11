import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPurchasedBooksbyEmailComponent } from './all-purchased-booksby-email.component';

describe('AllPurchasedBooksbyEmailComponent', () => {
  let component: AllPurchasedBooksbyEmailComponent;
  let fixture: ComponentFixture<AllPurchasedBooksbyEmailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllPurchasedBooksbyEmailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllPurchasedBooksbyEmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
