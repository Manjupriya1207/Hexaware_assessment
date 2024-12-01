import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginHeaderComponent } from "../../components/login-header/login-header.component";

@Component({
  selector: 'app-auth-page',
  imports: [RouterOutlet, LoginHeaderComponent],
  templateUrl: './auth-page.component.html',
  styleUrl: './auth-page.component.css'
})
export class AuthPageComponent {

}
