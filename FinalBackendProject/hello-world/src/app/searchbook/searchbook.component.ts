import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BookService } from '../book.service';
import { BookformComponent } from '../bookform/bookform.component';

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.css']
})
export class SearchbookComponent implements OnInit {
  book={
    author:"Jhon",
    catagory:"High",
    price:999
  }
  searchbook(){
    const observable: Observable<any>= this.bookService.searchBooks(this.book);
    observable.subscribe(
      responce =>{//success.fuction
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
