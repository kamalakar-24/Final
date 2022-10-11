import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BookService } from '../book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  book={
    bookId:"2",
    title:"Java ",
    active:"true",
    catagory:"medium",
    isBlocked:"false",
    price:"999",
    publisher:"sam"
  }
  updateBook(){
    if(this.book.bookId=="")
  {
    alert("Please enter bookId")
  }
  else if(this.book.active=="")
  {
    alert("Please Enter Active")
  }
  if(this.book.catagory=="")
    {
      alert("Please enter Catagory")
    }
    else if(this.book.isBlocked=="")
    {
      alert("Please Enter isBlocked")
    }
    else if(this.book.price=="")
    {
      alert("Please Enter price")
    }
    else if(this.book.publisher=="")
    {
      alert("Please Enter publisher")
    }
  
    else{
    const observable: Observable<any>= this.bookService.updateBook(this.book);
    observable.subscribe(
      responce =>{//success.fuction
        console.log(responce);
       },
       error=>{
         console.log(error);
       }
    )
      }
  }
  constructor(private bookService : BookService) { }
  ngOnInit(): void {
  }
}
