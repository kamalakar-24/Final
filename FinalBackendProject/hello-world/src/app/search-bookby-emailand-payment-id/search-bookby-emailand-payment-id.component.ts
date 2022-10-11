import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BookService } from '../book.service';

@Component({
  selector: 'app-search-bookby-emailand-payment-id',
  templateUrl: './search-bookby-emailand-payment-id.component.html',
  styleUrls: ['./search-bookby-emailand-payment-id.component.css']
})
export class SearchBookbyEmailandPaymentIdComponent implements OnInit {
  book={
    email:"tkar24@gmail.com",
    paymentId:24
  }
  save(){
    if(this.book.paymentId==0)
    {
      alert("Please enter paymentId")
    }
    else if(this.book.email=="")
    {
      alert("Please Enter email")
    }
    const observable:Observable<any>=this.bookService.SearchBookbyMailandpaymentId(this.book);
    observable.subscribe(
      responce=>{
        console.log(responce);
      },
      error=>{
        console.log(error);
      }
    )
  }
  constructor(private bookService: BookService) { }

  ngOnInit(): void {
  }

}
