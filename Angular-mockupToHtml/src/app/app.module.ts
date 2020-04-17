import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {Ng2PageScrollModule} from 'ng2-page-scroll';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule , HTTP_INTERCEPTORS } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { NavbarAppComponent } from './Components/navbar-app/navbar-app.component';
import { IndexContentComponent } from './Components/index-content/index-content.component';
import { HomeComponent } from './Pages/home/home.component';
import { ProjectsComponent } from './Pages/projects/projects.component';
import { HelpComponent } from './Pages/help/help.component';
import { AboutComponent } from './Pages/about/about.component';
import { LoginComponent } from './Components/login/login.component';

import { RegistrationComponent } from './Components/registration/registration.component';
import { BasicAuthHtppInterceptorService } from './service/basic-auth-interceptor.service';
import { Builder } from 'protractor';
import { LoginPageComponent } from './Pages/login-page/login-page.component';
import { RegistrationPageComponent } from './Pages/registration-page/registration-page.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NavbarAppComponent,
    IndexContentComponent,
    HomeComponent,
    ProjectsComponent,
    HelpComponent,
    AboutComponent,
    LoginComponent,
    RegistrationComponent,
    LoginPageComponent,
    RegistrationPageComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Ng2PageScrollModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{
    provide:HTTP_INTERCEPTORS, useClass:BasicAuthHtppInterceptorService, multi:true
  }
  ],
  bootstrap: [AppComponent]
})

export class AppModule { 
  
}
