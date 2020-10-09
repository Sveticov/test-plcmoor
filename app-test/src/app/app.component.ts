import {Component} from '@angular/core';
import {stringify} from "querystring";
import {AppDataService} from "./service/app-data.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app-test';
  pipleTest: Piple;
  piple = new Piple("", null)

  constructor(private servicePiple: AppDataService) {
  }

  // var textEdit

  onCreatePiple() {
    // alert(JSON.stringify(this.piple))
    // var textEdit=this.piple.name.toUpperCase().split("DB")
    // var numb=textEdit[1].replace(".","")
    // var numb2=textEdit[2].replace("X","")
    // var bytef=numb2.split(".")
    // var byte=bytef[0]
    // var bite=bytef[1]
    // console.log(textEdit)
    // console.log(numb)
    // console.log(byte+"  "+bite)
    console.log("success")
    this.servicePiple.onCreatePipleService(this.piple)
      .subscribe(p=>{this.pipleTest=p;
      console.log(p);})
    console.log(" piple "+this.pipleTest)
  }
}

export class Piple {

  constructor(
    public name: string,
    public age: number
  ) {
  }
}
