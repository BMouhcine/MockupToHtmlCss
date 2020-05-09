import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../service/authentification.service';


@Component({
  selector: 'app-navbar-app',
  templateUrl: './navbar-app.component.html',
  styleUrls: ['./navbar-app.component.css']
})
export class NavbarAppComponent implements OnInit {
  
  @Input() username: any ; 
  @Input() directive: any ; 
  
  
  constructor(private router: Router,private service: AuthenticationService) {
    
   }

  ngOnInit(): void {
    
    if (this.service.isUserLoggedIn) {
      
      if(sessionStorage.getItem('token') && sessionStorage.getItem('username')){
        this.directive='?'+sessionStorage.getItem("token").substring(13,18)
        this.username=sessionStorage.getItem('username')
      }
      
      
    }else{
      this.username=''
      this.directive=''
      
    }
  
 
   
    
    
  }
  logout() {
    this.service.logOut()
        this.router.navigate(['/'])
    }
}
