import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';

export class User {
  constructor(public status: string) {}
}


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  token : string 
  id : string
  constructor(private http: HttpClient) {}
// Provide username and password for authentication, and once authentication is successful, 
//store JWT token in session
  authenticate(username, password) {
    return this.http
      .post<any>("http://localhost:8080/login", { username, password },{observe: 'response'})
      .pipe(
        map((res:any) => {
          console.log(res)
          sessionStorage.setItem('username',username)
          sessionStorage.setItem('password',password)
          this.token = res.headers.get('authorization')
          this.id = res.headers.get('id_user')
          sessionStorage.setItem('id',this.id)
          sessionStorage.setItem('token',this.token)
          return res;
        })
      );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("username");
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("password");
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("id");
  }
  // Provide username and email and password and repassword for registration, and once authentication is successful, 
//store JWT token in session
registration(username, email ,password,repassword) {
  return this.http
    .post<any>("http://localhost:8080/createUser", { username,email,password,repassword },{observe: 'response',responseType:'json'})
    .pipe(
      map((res:any) => {
        console.log(res)
        return res;
      })
    );
}


}

