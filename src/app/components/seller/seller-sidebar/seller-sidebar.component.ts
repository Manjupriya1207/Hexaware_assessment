import { Component } from '@angular/core';
import { SellerService } from '../../../service/seller.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-seller-sidebar',
  imports: [FormsModule,NgIf],
  templateUrl: './seller-sidebar.component.html',
  styleUrl: './seller-sidebar.component.css'
})
export class SellerSidebarComponent {
  UserId:string="";
  name: string="";
  contactInfo:string="";
  location:string="";
  successMsg:any;
  errorMsg: any;
  constructor(private sellerService: SellerService,private router:Router){}
  onContinue(){
    console.log(this.UserId)
    console.log(this.name);
    console.log(this.contactInfo);
    console.log(this.location);
    this.sellerService.sellercontinue({
      user_id:this.UserId,
      name:this.name,
      ContactInfo:this.contactInfo,
      Location:this.location
    }).subscribe({
      next: (data)=>{
        this.successMsg = 'Sign Up Success, Please login';
        localStorage.clear(); // Clear only on success
        this.router.navigateByUrl('onlineevaluation');
      },
      error: (err: { msg: any; })=>{
        console.log(err)
        this.errorMsg = err.msg; 
      }
    })
    
  }
}


