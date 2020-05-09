import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../service/authentification.service';
import {Profile} from '../../schemas/profile'

@Component({
  selector: 'app-navbar-app',
  templateUrl: './navbar-app.component.html',
  styleUrls: ['./navbar-app.component.css']
})

export class NavbarAppComponent implements OnInit {
  
  @Input() data : Profile ; 
  
  constructor(private router: Router,private service: AuthenticationService) { }

  ngOnInit(): void {
    if (this.service.isUserLoggedIn) {
      this.data.username=sessionStorage.getItem('username')
      this.data.id=sessionStorage.getItem('id')
      this.data.token=sessionStorage.getItem('token')
      this.data.directive=sessionStorage.getItem("id")+sessionStorage.getItem("token").substring(8,13)
    }else{
      this.data.username=''
      this.data.id=''
      this.data.token=''   
     }
    
    
  }
  logout() {
    this.service.logOut()
        this.router.navigate(['/'])
    }
}
