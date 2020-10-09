import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {PLC} from "../app-plc.component";

@Injectable({
  providedIn: 'root'
})
export class PlcService {
host='http://localhost:8080'
  constructor(private http:HttpClient) { }

  findAllPLC():Observable<any>{
  return this.http.get(this.host+'/all')
  }

  deletePLC(plc: PLC):Observable<any> {
  const options={
    headers: new HttpHeaders({'Content-Type':'application/json',}),
      body:plc};

    return this.http.delete(this.host+'/delete',options)
  }

  createPLC(plc:PLC):Observable<any>{
  return this.http.post(this.host+'/create',plc)
  }
}
