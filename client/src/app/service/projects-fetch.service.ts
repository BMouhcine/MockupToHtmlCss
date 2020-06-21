import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map } from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class ProjectsFetchService {
  
  constructor(private http: HttpClient) {}
   
  
  FetchProjects(user_id){
    return this.http.post('http://localhost:8080/getAllCodes',{observe: 'response'}).pipe(
      map((res:any) => {
        console.log(res)
        return res;
      })
    );
  }

  
}
