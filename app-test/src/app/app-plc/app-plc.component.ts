import {Component, OnInit} from '@angular/core';
import {PlcService} from "./service plc/plc.service";

@Component({
  selector: 'app-app-plc',
  templateUrl: './app-plc.component.html',
  styleUrls: ['./app-plc.component.scss']
})
export class AppPlcComponent {
  plc = new PLC("",false)
  plcAll:PLC[]

  constructor(private plcService: PlcService) {
  }


  onFindAllPLC() {
    this.plcService.findAllPLC().subscribe(
      plc => this.plcAll=plc)
  }

  onDeletePLC(plc: PLC) {
    this.plcService.deletePLC(plc)
    .subscribe(status=>console.log(status))
    this.onFindAllPLC()
  }

  onCreatePLC(){
    this.plcService.createPLC(this.plc)
      .subscribe(plc=>this.plc=plc)
    this.onFindAllPLC()
  }
}

export class PLC {
  constructor(public namePLC: String,
              public statusPLC: boolean) {
  }
}
