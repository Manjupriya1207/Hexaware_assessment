import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seller-navbar',
  imports: [],
  templateUrl: './seller-navbar.component.html',
  styleUrl: './seller-navbar.component.css'
})
export class SellerNavbarComponent {
  name: any; 
  
  constructor(private router: Router){
    this.name = localStorage.getItem('name');
  }
  logout(){
      localStorage.clear();
      this.router.navigateByUrl('login?msg=you have successfully logged out')
  }

}
