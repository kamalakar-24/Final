import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  BASE_URL ="http://54.147.61.125:9090/api/auth/";
  //BASE_URL ="http://localhost:9090/api/auth/";
  signup(user :any){
    return this.http.post(this.BASE_URL+'signup',user);
  }


  signin(user :any){
    return this.http.post(this.BASE_URL+'signin',user);
  }


  constructor(private http: HttpClient) { }
}
