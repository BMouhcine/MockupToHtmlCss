import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DragAndDropService } from '../../service/drag-and-drop.service';

@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.scss']
})
export class AcceuilComponent implements OnInit {

  constructor(private router: Router,private imageservice: DragAndDropService ) { }

  ngOnInit(): void {
  }

  uploadedFiles: any[] = [];

  upload(event) {
    for (let file of event.files) {
      this.uploadedFiles.push(file);
    }
    (this.imageservice.addFiles(this.uploadedFiles).subscribe(
      data => {
        //we gonna change this to :id/projects
        this.router.navigate([sessionStorage.getItem("id")+sessionStorage.getItem("token").substring(8,13)+'/projects'])
      },
      error => {
        console.log(error);

      }
    )
    );
    console.log(this.uploadedFiles)
  }

}
