import { Component, OnInit } from '@angular/core';
import * as tf from '@tensorflow/tfjs';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.css']
})
export class HelpComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  	
  	this.weightHandler()
	}
	async weightHandler(){
  //const model = await tf.loadLayersModel("/assets/tfjsmodel/model.json");
  //const prediction = model.predict(tf.browser.toPixels("/assets/img.png"));
  //console.log(prediction)
  }
  
}
