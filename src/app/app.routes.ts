import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { SellerPageComponent } from './pages/seller-page/seller-page.component';
import { OnlineEvaluationPageComponent } from './pages/online-evaluation-page/online-evaluation-page.component';

export const routes: Routes = [
    {
        path:'login',component:LoginComponent
    },
    {
        path:'sign-up',component:SignUpComponent
    },
    {
        path:'seller',component:SellerPageComponent
    },
    {
        path:'onlineEvaluation',component:OnlineEvaluationPageComponent
    }
];
