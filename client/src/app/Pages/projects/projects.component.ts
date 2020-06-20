import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ProjectsFetchService } from '../../service/projects-fetch.service';
import { saveAs } from 'file-saver';
 
 
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
 
                this.Projects = data;
                console.log(this.Projects[0]);
       })
}
preview(project:any) {
  console.log(typeof(project));
  let blob = new Blob([project], {type: 'text/html'});
        let url = window.URL.createObjectURL(blob);
        let pwa = window.open(url);
        if (!pwa || pwa.closed || typeof pwa.closed == 'undefined') {
            alert( 'Please disable your Pop-up blocker and try again.');
        }
       
  }
  download(project:any) {
    console.log(typeof(project));
    let blob = new Blob([project], {type: 'text/html'});
          let url = window.URL.createObjectURL(blob);
          let pwa = window.open(url);
          if (!pwa || pwa.closed || typeof pwa.closed == 'undefined') {
              alert( 'Please disable your Pop-up blocker and try again.');
          }
          saveAs.saveAs(blob, "hello world.html");
         
    }
 
 
}
