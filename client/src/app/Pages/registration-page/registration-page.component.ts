import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {

  constructor(private titleService:Title) { 
    this.titleService.setTitle("Projects");
  }

  ngOnInit(): void {
  }

}
