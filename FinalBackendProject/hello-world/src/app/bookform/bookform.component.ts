import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';

@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.css']
})
export class BookformComponent implements OnInit {
book={
  title:"JAVA ",
  active:"true",
  author:"Jhon",
  catagory:"High",
  content:"Core Java",
  isBlocked:"true",
  price:"999",
  publishedDate:"4/4/2022",
  publisher:"sam"
}

save(){
  if(this.book.title=="")
  {
    alert("Please enter Title")
  }
  else if(this.book.active=="")
  {
    alert("Please Enter Active")
  }
  else if(this.book.author=="")
  {
    alert("Please Enter Author")
  }
  if(this.book.catagory=="")
    {
      alert("Please enter Catagory")
    }
    else if(this.book.content=="")
    {
      alert("Please Enter content")
    }
    else if(this.book.isBlocked=="")
    {
      alert("Please Enter isBlocked")
    }
    else if(this.book.price=="")
    {
      alert("Please Enter price")
    }
    else if(this.book.publishedDate=="")
    {
      alert("Please Enter publisherDate")
    }
    else if(this.book.publisher=="")
    {
      alert("Please Enter publisher")
    }
  
    else{
  
  console.log('saved');
  const observable= this.bookService.saveBook(this.book);
  observable.subscribe(response=>{
    console.log(response);
  })
}
}

constructor(private bookService : BookService) { }
  ngOnInit(): void {
  }

}
