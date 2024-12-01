import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class EvaluationService{
  
    private EvaluationApi = 'http://localhost:8081/api/evaluations/add';

    constructor(private httpClient: HttpClient){}
    
      public Evaluation(obj: any) :Observable<any>{
        let postObj = {
          brand: obj.brand,
          RtoLocation: obj.RtoLocation,
          ManufacturingYear: obj.ManufacturingYear,
          Model:obj.Model,
          Variant:obj.Variant,
          KmDriven:obj.KmDriven,
          carOwnership:obj.carOwnership,
          UserLocation:obj.UserLocation,
          seller:{
            sellerId: obj.sellerId
          }
        };
         return this.httpClient.post(this.EvaluationApi,postObj)
      }
} 
// const httpOptions = {
        //   headers: new HttpHeaders({
        //      Authorization: 'Bearer '+ localStorage.getItem('token')
        //   })
        // };
