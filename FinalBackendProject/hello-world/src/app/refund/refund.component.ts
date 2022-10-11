import { Component, OnInit } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { BookService } from '../book.service';

@Component({
  selector: 'app-refund',
  templateUrl: './refund.component.html',
  styleUrls: ['./refund.component.css']
})
export class RefundComponent implements OnInit {
book={
  bookId:'1',
  paymentId:'4',
  email:"tkr3@gmail.com",
  refundAmount:'999'
}
refund(){
  if(this.book.bookId=="")
  {
    alert("Please enter bookId")
  }
  else if(this.book.paymentId=="")
  {
    alert("Please Enter paymentId")
  }
  else if(this.book.email=="")
  {
    alert("Please Enter email")
  }
  else if(this.book.refundAmount=="")
  {
    alert("Please Enter refundAmount")
  }
  else{
  const observable:Observable<any>= this.bookService.refund(this.book);
  observable.subscribe(
    responce=>{
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
