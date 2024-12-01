import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SellerService } from '../../../service/seller.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-seller-onlineevaluation',
  imports: [NgIf,ReactiveFormsModule,FormsModule],
  templateUrl: './seller-onlineevaluation.component.html',
  styleUrl: './seller-onlineevaluation.component.css'
})
export class SellerOnlineevaluationComponent {
  years: number[] = [];
  successMsg: string | undefined;
  errorMsg: string | undefined; 
  onlineEvaluationForm : FormGroup;
  models: string[] = [];

  constructor(private sellerService: SellerService){
    this.onlineEvaluationForm = new FormGroup({
      seller: new FormControl('',[Validators.required]),
      Brand: new FormControl('',[Validators.required]),
      RtoLocation: new FormControl('',[Validators.required]),
      ManufacturingYear: new FormControl('',[Validators.required]),
      Model: new FormControl('', [Validators.required]),
      Variant: new FormControl('',[Validators.required]),
      KmDriven: new FormControl('',[Validators.required]),
      carOwnership: new FormControl('',[Validators.required]),
      userLocation:new FormControl('',[Validators.required])
    })

  }
  

  onFormSubmit(){
    console.log(this.onlineEvaluationForm.value)
    
    this.sellerService.sellercontinue(this.onlineEvaluationForm.value).subscribe({
      next: (data)=>{
        this.successMsg = 'Applied for OnlineEvaluation successfully,please continue';
        this.errorMsg = undefined;
      },
      error: (err)=>{
        this.errorMsg = err.error.msg; 
      }
    })
  }
  resetMsg(){
    this.errorMsg = undefined; 
    this.successMsg = undefined; 
  }

  brandModelMapping: { [key: string]: string[] } = {
    Hyundai: ['i10', 'i20', 'Creta'],
    Honda: ['City', 'Civic', 'Accord'],
    Tata: ['Nexon', 'Harrier', 'Altroz'],
    'Rolls-Royce': ['Phantom', 'Ghost', 'Wraith'],
    Toyota: ['Corolla', 'Camry', 'Fortuner'],
    Mahindra: ['XUV500', 'Thar', 'Scorpio'],
    Kia: ['Seltos', 'Sonet', 'Carnival'],
    Volkswagen: ['Polo', 'Tiguan', 'Jetta'],
    MG: ['Hector', 'Zs EV', 'Astor'],
    Renault: ['Kwid', 'Duster', 'Kiger'],
    Skoda: ['Octavia', 'Kodiaq', 'Rapid'],
    BMW: ['3 Series', 'X5', 'Z4'],
    Jeep: ['Compass', 'Wrangler', 'Renegade'],
    Maruti: ['Swift', 'Baleno', 'Vitara Brezza'],
    Audi: ['A4', 'Q5', 'A6'],
    Ford: ['Ecosport', 'Endeavour', 'Figo'],
    Nissan: ['Kicks', 'Magnite', 'Sunny'],
    'Mahindra Renault': ['Duster', 'Koleos']
    
  };

 
  updateModels(brand: string) {
    this.models = this.brandModelMapping[brand as keyof typeof this.brandModelMapping] || [];
    // Reset model selection
  }

  carData: { [brand: string]: string[] } = {
    Toyota: ['Corolla', 'Camry', 'Fortuner'],
    Mahindra: ['XUV500', 'Thar', 'Scorpio'],
    Kia: ['Seltos', 'Sonet', 'Carnival'],
    Volkswagen: ['Polo', 'Tiguan', 'Jetta'],
    MG: ['Hector', 'Zs EV', 'Astor'],
    Renault: ['Kwid', 'Duster', 'Kiger'],
    Skoda: ['Octavia', 'Kodiaq', 'Rapid'],
    BMW: ['3 Series', 'X5', 'Z4'],
    Jeep: ['Compass', 'Wrangler', 'Renegade'],
    Maruti: ['Swift', 'Baleno', 'Vitara Brezza'],
    Audi: ['A4', 'Q5', 'A6'],
    Ford: ['Ecosport', 'Endeavour', 'Figo'],
    Nissan: ['Kicks', 'Magnite', 'Sunny'],
    'Mahindra Renault': ['Duster', 'Koleos']
  };

  carBrands: string[] = [];
  carModels: string[] = [];
  selectedBrand: string = '';
  selectedModel: string = '';

  ngOnInit() {
    // Initialize the list of car brands
    this.carBrands = Object.keys(this.carData);
  }

  onBrandChange() {
    // Update the car models based on the selected brand
    if (this.selectedBrand) {
      this.carModels = this.carData[this.selectedBrand];
    } else {
      this.carModels = [];
    }
  }
};
  
  
  // // Accessing the models
  // updateModels(brand: string) {
  //   this.models = this.brandModelMapping[brand] || [];
  //   this.onlineEvaluationForm.get('Model')?.setValue(''); // Reset model selection
  // }







