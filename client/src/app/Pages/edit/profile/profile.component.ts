import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentification.service';
import { Title } from '@angular/platform-browser';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  username = ''
  password = ''
  
  password1 = ''
  constructor(private router: Router,private editservice: AuthenticationService,private titleService:Title) {
    this.titleService.setTitle("Profile");
   }

  ngOnInit(): void {
  }
  editProfile(){
    
  (this.editservice.editProfile(this.password,this.password1) .subscribe(
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
