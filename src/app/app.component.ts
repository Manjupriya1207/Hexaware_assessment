import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginHeaderComponent } from "./components/login-header/login-header.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,LoginHeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'used-car-seller-app';
}
