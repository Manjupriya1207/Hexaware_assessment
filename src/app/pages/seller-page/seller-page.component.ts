import { Component } from '@angular/core';
import { SellerNavbarComponent } from "../../components/seller/seller-navbar/seller-navbar.component";
import { RouterOutlet } from '@angular/router';
import { SellerSidebarComponent } from "../../components/seller/seller-sidebar/seller-sidebar.component";

@Component({
  selector: 'app-seller-page',
  imports: [SellerNavbarComponent, RouterOutlet, SellerSidebarComponent],
  templateUrl: './seller-page.component.html',
  styleUrl: './seller-page.component.css'
})
export class SellerPageComponent {

}
