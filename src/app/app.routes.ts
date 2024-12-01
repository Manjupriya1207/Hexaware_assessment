import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { SellerPageComponent } from './pages/seller-page/seller-page.component';
import { AuthPageComponent } from './pages/auth-page/auth-page.component';
import { SellerDoorstepinspectionComponent } from './components/seller/seller-doorstepinspection/seller-doorstepinspection.component';
import { SellerDocumentComponent } from './components/seller/seller-document/seller-document.component';
import { SellerPaymentComponent } from './components/seller/seller-payment/seller-payment.component';
import { SellerPickupComponent } from './components/seller/seller-pickup/seller-pickup.component';
import { SellerDashboardComponent } from './components/seller/seller-dashboard/seller-dashboard.component';
import { SellerOnlineevaluationComponent } from './components/seller/seller-onlineevaluation/seller-onlineevaluation.component';

export const routes: Routes = [
    {
        path: '' , component: AuthPageComponent, children: [
            {
                path:'login',component:LoginComponent
            },
            {
                path:'sign-up',component:SignUpComponent
            }
        ]
        }   
    ,
    {
        path:'seller',component:SellerPageComponent,children:[
            {
                path:'onlineEvaluation',component:SellerOnlineevaluationComponent
            },
            {
                path:'doorStepInspection',component:SellerDoorstepinspectionComponent
            },
            {
                path:'document',component:SellerDocumentComponent
            },
            {
                path:'payment',component:SellerPaymentComponent
            },
            {
                path:'pickup',component:SellerPickupComponent
            },
            {
                path:'dashboard',component:SellerDashboardComponent
            }
        ]
    }
    
];
