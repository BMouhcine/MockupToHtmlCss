import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentification.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  username = ''
  password = ''
  username1 = ''
  password1 = ''
  constructor(private router: Router,private editservice: AuthenticationService) { }

  ngOnInit(): void {
  }
  editProfile(){
    
  (this.editservice.editProfile(this.username, this.username1 ,this.password,this.password1) .subscribe(
      data => {
        //A reviser !!!!!!
        this.router.navigate([sessionStorage.getItem("id")+sessionStorage.getItem("token").substring(8,13)+'/acceuil'])
      },
      error => {
        console.log(error);

      }
    )
    );
    }

}
