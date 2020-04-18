import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../service/authentification.service';

@Component({
  selector: 'app-navbar-app',
  templateUrl: './navbar-app.component.html',
  styleUrls: ['./navbar-app.component.css']
})
export class NavbarAppComponent implements OnInit {
  @Input() username: string ; 
  
;
  constructor(private router: Router,private service: AuthenticationService) { }

  ngOnInit(): void {
    if (this.service.isUserLoggedIn) {
      this.username=sessionStorage.getItem('username')
    }else{
      this.username=''

    }
  }
  logout() {
    this.service.logOut()
        this.router.navigate(['/'])
    }
}
