import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { BookService } from '../book.service';

@Component({
  selector: 'app-all-purchased-booksby-email',
  templateUrl: './all-purchased-booksby-email.component.html',
  styleUrls: ['./all-purchased-booksby-email.component.css']
})
export class AllPurchasedBooksbyEmailComponent implements OnInit {
book={
  email:"tkr24@gmail.com"
}
save(){
  if(this.book.email=="")
  {
    alert("Please enter email")
  }
  const observable: Observable<any> =this.bookService.allPurchasedBooks(this.book);
  observable.subscribe(
    responce=>{
      console.log(responce);
    },
    error=>{
      console.log(error);
    }
  )
}
  constructor(private bookService : BookService) { }

  ngOnInit(): void {
  }

}
