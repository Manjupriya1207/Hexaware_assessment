import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SellerService } from '../../../service/seller.service';

@Component({
  selector: 'app-seller-dashboard',
  imports: [NgIf,ReactiveFormsModule],
  templateUrl: './seller-dashboard.component.html',
  styleUrl: './seller-dashboard.component.css'
})
export class SellerDashboardComponent {
  successMsg: string | undefined;
  errorMsg: string | undefined; 
  sellerForm : FormGroup;
  constructor(private sellerService: SellerService){
    this.sellerForm = new FormGroup({
      name: new FormControl('',[Validators.required]),
      contact: new FormControl('',[Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
      location: new FormControl('',[Validators.required]),
      userid: new FormControl('', [Validators.required]),
      username: new FormControl('',[Validators.required,Validators.minLength(4)]),
      password: new FormControl('',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/)]),
      rePassword: new FormControl('',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/)])
    })

  }
  
  onFormSubmit(){
    console.log(this.sellerForm.value)
    
    this.sellerService.sellercontinue(this.sellerForm.value).subscribe({
      next: (data)=>{
        this.successMsg = 'seller id create successfully,please continue';
        this.errorMsg = undefined;
      },
      error: (err)=>{
        this.errorMsg = err.error.msg; 
      }
    })
  }
  resetMsg(){
    this.errorMsg = undefined; 
    this.successMsg = undefined; 
  }
}






