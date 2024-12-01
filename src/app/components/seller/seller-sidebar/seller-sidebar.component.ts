import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-seller-sidebar',
  imports: [NgClass,RouterLink],
  templateUrl: './seller-sidebar.component.html',
  styleUrl: './seller-sidebar.component.css'
})
export class SellerSidebarComponent {
  linkType: string='';
   
  linkClick(linkType:string){
    this.linkType = linkType;
  }

  getClassSeller(){
    return {
      active: this.linkType === 'seller'?true: false
    }
  }
  getClassOnline(){
    return {
      active: this.linkType === 'onlineEvaluation'?true: false
    }
  }

  getClassDoorStep(){
    return {
      active: this.linkType === 'door-stepInspection'?true: false
    }
  }
  getClassDocument(){
    return {
      active: this.linkType === 'document'?true: false
    }
  }
  getClassPayment(){
    return {
      active: this.linkType === 'payment'?true: false
    }
  }
  getClassPickup(){
    return {
      active: this.linkType === 'pickup'?true: false
    }
  }

  

}