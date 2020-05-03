import { Component, OnInit ,Input} from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../service/authentification.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  
  username = ''
  password = ''
  email = ''
  repassword = ''
  isRegistred = false
  
  @Input() error: string | null;

  constructor(private router: Router,private registrationservice: AuthenticationService) { }

  ngOnInit() {
  }
  checkRegistration() {
    (this.registrationservice.registration(this.username, this.email,this.password,this.repassword).subscribe(
      data => {
        //the help routing is just to test
        console.log(data);
        this.router.navigate(['login'])
        this.isRegistred = false
      },
      error => {
        this.isRegistred = true
        this.error = error.message;
        console.log(this.error);

      }
    )
    );
    }
  

}
