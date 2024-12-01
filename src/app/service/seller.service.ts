import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class SellerService{
  
    private sellercontinueApi = 'http://localhost:8081/seller/add';

    constructor(private httpClient: HttpClient){}
    
      public sellercontinue(obj: any) :Observable<any>{
        let postObj = {
          name: obj.name,
          contactInfo: obj.contactInfo,
          location: obj.location,
          user:{
               userid: obj.userid,
               username: obj.username,
               password: obj.password,
          }
        };
      
    
        const httpOptions = {
          headers: new HttpHeaders({
             Authorization: 'Bearer '+ localStorage.getItem('token')
          })
        };
         return this.httpClient.post(this.sellercontinueApi,postObj,httpOptions)
      }
}