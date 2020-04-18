import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './Pages/home/home.component';
import { AboutComponent } from './Pages/about/about.component';
import { HelpComponent } from './Pages/help/help.component';
import { ProjectsComponent } from './Pages/projects/projects.component';
import { LoginPageComponent } from './Pages/login-page/login-page.component';
import { RegistrationPageComponent } from './Pages/registration-page/registration-page.component';




const routes: Routes = [
    { path: '', component: HomeComponent },  
    { path: 'about', component: AboutComponent },  
    { path: 'help', component: HelpComponent },
    { path: 'projects', component: ProjectsComponent },
    { path: 'login', component: LoginPageComponent },
    { path: 'registration', component: RegistrationPageComponent },
    

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
