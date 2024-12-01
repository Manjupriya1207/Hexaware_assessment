import { Component } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-sign-up',
  imports: [FormsModule,NgIf],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {
  name: string ="";
  username: string ="";
  password: string="";
  errorMsg: string | undefined;
  successMsg: string | undefined;
  constructor(private authService: AuthService){}
  onSignUp(){
    console.log(this.name);
    console.log(this.username);
    console.log(this.password);
    this.authService.signUp({
      name: this.name,
      username: this.username,
      password: this.password
    }).subscribe({
      next: (data)=>{
        this.successMsg = 'Sign Up Success, Please login';
      },
      error: (err)=>{
        console.log(err)
        this.errorMsg = err.msg; 
      }
    })
  }


}
