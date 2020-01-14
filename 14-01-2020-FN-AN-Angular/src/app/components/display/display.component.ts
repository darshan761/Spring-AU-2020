import { Component, OnInit } from '@angular/core';
import { ShowService } from 'src/app/providers/show.service';


@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

   name:any = []
  constructor(public SaveService: ShowService) { }
  inputDisabled = true;
  ngOnInit() {
    this.name = this.SaveService.formData
    console.log(this.name)
  }

  edit(){
    this.inputDisabled = false;
  }

  save(ind){
    this.inputDisabled = true;
  }

  delete(index){
    this.SaveService.delete(index);
  }

}
