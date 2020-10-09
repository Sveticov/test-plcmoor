import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Piple} from "../app.component";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AppDataService {
 host='http://localhost:8080/piple'
  constructor(private http:HttpClient) { }

  onCreatePipleService(piple:Piple):Observable<Piple>{
   return this.http.post<Piple>(this.host+'/create',piple)
  }

}
