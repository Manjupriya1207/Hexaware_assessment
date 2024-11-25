import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class SellerService{
  
    private sellercontinueApi = 'http://localhost:8081/seller';
    private UserApi='http://localhost:8081/auth/user';

    constructor(private httpClient: HttpClient){}
    sellercontinue(seller: any) : Observable<any>{
        return this.httpClient.post(this.sellercontinueApi,seller);
        // return this.httpClient.post(`${this.sellercontinueApi}?userId=${userId}`, body, { headers });
      }
}