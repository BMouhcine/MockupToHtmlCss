import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ProjectsFetchService } from '../../service/projects-fetch.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  Projects :any 
  constructor(private projectsservice: ProjectsFetchService,private titleService:Title) {
    this.titleService.setTitle("Projects");
   }
 
 
   ngOnInit(): void {
    //the FetchProjetcs Function
      this.projectsservice.FetchProjects(sessionStorage.getItem("id"))
           .subscribe(data => {
                this.Projects = data.total;
       })
}


}
