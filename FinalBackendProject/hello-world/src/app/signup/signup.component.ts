import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../user.service';

@Component({
  selector: 'signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user = {
    username:"kamalaakar",
    password:"123456",
    email:"tkr24@gmail.com",
    role:""
    
    }
    user1= {
      username:"",
      password:"",
      email:"",
      role:[""]
      
      }
    signup(){
      if(this.user.username=="")
    {
      alert("Please enter username")
    }
    else if(this.user.password=="")
    {
      alert("Please Enter Password")
    }
    else if(this.user.email=="")
    {
      alert("Please Enter Email")
    }
    else{
      this.user1.username=this.user.username;
    this.user1.email=this.user.email;
    this.user1.password=this.user.password;
    const result: any[] = [];
    result[0]=this.user.role;
   this.user1.role=result;
   
      const observable: Observable<any>= this.userService.signup(this.user1);
      observable.subscribe(
       (responce :any) =>{//success.fuction
        // sessionStorage.setItem("user", JSON.stringify(responce));
        //   if(responce.role[0]="ROLE_AUTHOR"){
        //     this.router.navigate(['author']);
        //   } else if(responce.role[0]="ROLE_READER"){
        //     this.router.navigate(['']);
        //   }
          console.log(responce);
          this.router.navigate(['signin']);
         },
         error=>{
           console.log(error);
         }
      )
        }
    }
  constructor(private userService: UserService, private router: Router) { }
  ngOnInit(): void {
  }
 

}
