import { Component, OnInit ,Input} from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../service/authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false
  
  @Input() error: string | null;

  constructor(private router: Router,private loginservice: AuthenticationService) { }

  ngOnInit() {
  }
  checkLogin() {
    (this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {
        //the help routing is just to test

        this.router.navigate([sessionStorage.getItem("id")+sessionStorage.getItem("token").substring(8,13)+'/projects'])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
        this.error = error.message;
        console.log(this.error);

      }
    )
    );
    }
  }
