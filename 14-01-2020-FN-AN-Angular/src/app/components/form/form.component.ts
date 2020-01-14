import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ShowService } from 'src/app/providers/show.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(public SaveService: ShowService) { 

  }

  myForm = new FormGroup({
    name: new FormControl('',Validators.required),
    email: new FormControl('darshan@7gmail.com',Validators.required),
    ssn : new FormControl('', Validators.required),
    username : new FormControl('',Validators.required),
  });

  ngOnInit() {
    console.log(this.myForm.value)
  }

  reset(){
    
  }

  saveForm(){
    this.SaveService.setData(this.myForm.value);
    console.log(this.myForm.value);
    this.myForm.reset();
  }

}
