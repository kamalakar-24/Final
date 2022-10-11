import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  BASE_URL ="http://54.147.61.125:9090/api/book/";
 // BASE_URL ="http://localhost:9090/api/book/";
  saveBook(book: { title: string; }) {
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.post(this.BASE_URL+'createBook', book, {
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }
  updateBook(book :any){
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.put(this.BASE_URL+'updateBook',book,{
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }
  buyBooks(book :any){
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.post(this.BASE_URL+'buyBooks',book,{
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }
  refund(book :any){
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.put(this.BASE_URL+'refund',book,{
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }
  searchBooks(book :{catagory: string; author: string; price: number}){
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.get(this.BASE_URL+'searchBooks'+'?catagory='+book.catagory+'&author='+book.author+'&price='+book.price,{
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }
  allPurchasedBooks(book :{email: string }){
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.get(this.BASE_URL+'allPurchasedBooks/'+book.email,{
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }
  
  SearchBookbyMailandBookId(book :{email: string; bookId: number }){
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.get(this.BASE_URL+'readers/'+book.email+'/books/'+book.bookId,{
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }
  SearchBookbyMailandpaymentId(book :{email: string; paymentId:number }){
    const credentials = sessionStorage.getItem('credentials');
    const token: any = JSON.parse(credentials||'{}')['accessToken'];
    return this.http.get(this.BASE_URL+'readers/'+book.email+'/books/'+'paymentId/'+book.paymentId,{
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
  }
  constructor(private http: HttpClient) { }
}
