import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { SellerSidebarComponent } from "../seller-sidebar/seller-sidebar.component";

@Component({
  selector: 'app-seller-navbar',
  imports: [RouterLink],
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
