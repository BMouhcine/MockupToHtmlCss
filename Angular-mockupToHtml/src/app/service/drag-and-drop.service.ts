  
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpErrorResponse, HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DragAndDropService {

  constructor(private http: HttpClient) { }

  addFiles(images: any) {
    var formData = new FormData();
    formData.append('uploadFile', images[0]);
    
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer '+sessionStorage.getItem('token') });
    let options = { headers: headers };
    
    console.log(headers.get('authorization'))

    return this.http.post('http://localhost:8080/doUploadImage', formData, options).pipe(
      catchError(this.errorMgmt)
    )
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
