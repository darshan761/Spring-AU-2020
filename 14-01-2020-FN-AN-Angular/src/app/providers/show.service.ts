import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShowService {

  formData:any = []
  constructor() { }

  setData(value){
    this.formData.push(value);

  }

  delete(index){
    this.formData.splice(index, 1);
    // localStorage.setItem("val",this.formData)
  }

}
