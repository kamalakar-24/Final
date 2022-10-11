import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBookbyMailAndBookIdComponent } from './search-bookby-mail-and-book-id.component';

describe('SearchBookbyMailAndBookIdComponent', () => {
  let component: SearchBookbyMailAndBookIdComponent;
  let fixture: ComponentFixture<SearchBookbyMailAndBookIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchBookbyMailAndBookIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchBookbyMailAndBookIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
