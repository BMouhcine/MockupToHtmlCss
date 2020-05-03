import { Component, OnInit } from '@angular/core';
import { ProjectsFetchService } from '../../service/projects-fetch.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  Projects :any 
  constructor(private projectsservice: ProjectsFetchService) { }

  ngOnInit(): void {
    //the FetchProjetcs Function 
     /* this.projectsservice.FetchProjects(sessionStorage.getItem("id"))
           .subscribe(data => {
                this.Projects = data.total;
       })*/
  }

}
