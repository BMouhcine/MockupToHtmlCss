  
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { map } from "rxjs/operators";
import { catchError } from 'rxjs/operators';
import { HttpErrorResponse, HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DragAndDropService {

  constructor(private http: HttpClient) { }
 
  addFiles(images: any) {
    var user_id =sessionStorage.getItem("id")
    var formData = new FormData();
    formData.append('givenImage', images[0]);
    formData.append('user_id',user_id);
    console.log(user_id)
    


    
    return this.http
    .post('http://localhost:8080/doUploadImage', formData,{observe: 'response'})
    .pipe(  
        map((res:any) => {
          console.log(res)
          return res;
        })
      );
    
  }

  errorMgmt(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
