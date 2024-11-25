import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../../service/auth.service';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [FormsModule,NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string="";
  password: string="";
  successMsg: string | undefined;
  errorMsg:string | undefined;
  msg: string | undefined; 
  constructor(private authService: AuthService, private router: Router, 
              private actRoute: ActivatedRoute
  ){
    this.actRoute.queryParams.subscribe(p=>{
       this.msg = p['msg'];
    })
  }
  onLogin(){
    this.authService.login({
      username: this.username,
      password: this.password
    }).subscribe({
      next: (data)=>{
         let token = data.token; 
         /** you have to know the role of this user that has logged In 
          * use this token, call the api that gives you the full details of this loggedIn user 
         */
        this.authService.getUserDetails(token).subscribe({
          next: (data)=>{
            localStorage.setItem('token', token); 
            localStorage.setItem('username', data.username);
            localStorage.setItem('name', data.name);
            let role = data.role; 
            switch(role){
              case 'CUSTOMER':
                //console.log('i vl take you to customer screen')
                this.router.navigateByUrl("/seller");
                break; 
              case 'EXECUTIVE':
                //console.log('i vl take you to executive screen')
                this.router.navigateByUrl("/executive");
                break; 
              // case 'ADMIN': 
              //   //console.log('i vl take you to admin screen')
              //   this.router.navigateByUrl("/admin");
              //   break;
              default: 
                this.router.navigateByUrl("/broken-link");
                break; 
            }
          },
          error: (err)=>{
            this.errorMsg = err.error.msg; 
          }
        })
      },
      error: (err)=>{
        this.errorMsg = err.error.msg; 
      }
    })
  }

}
