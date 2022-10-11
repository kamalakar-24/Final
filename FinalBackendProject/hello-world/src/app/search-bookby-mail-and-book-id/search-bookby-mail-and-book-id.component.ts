import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BookService } from '../book.service';

@Component({
  selector: 'app-search-bookby-mail-and-book-id',
  templateUrl: './search-bookby-mail-and-book-id.component.html',
  styleUrls: ['./search-bookby-mail-and-book-id.component.css']
})
export class SearchBookbyMailAndBookIdComponent implements OnInit {
book={
  email:"tkr24@gmail.com",
  bookId:2
}
save(){
  if(this.book.email=="")
  {
    alert("Please enter email")
  }
  else if(this.book.bookId==0)
  {
    alert("Please Enter bookId")
  }
  const observable : Observable<any>=this.bookService.SearchBookbyMailandBookId(this.book);
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
