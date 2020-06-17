package com.project.mockup2html.Controllers;


import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nu.pattern.OpenCV;



@RestController
public class ViewController {
	
	//Login Register Handler
		@GetMapping("/login")
	    public String portalAngularHandler() {
			OpenCV.loadShared();
			Mat imgMat = loadImage(this.getClass().getClassLoader().getResource("static/assets/upload-icon.png").getFile());
			String dataString= String.valueOf(imgMat.size().width)+" : "+String.valueOf(imgMat.size().height);
			
			return dataString;
	        //return "forward:./index.html";
		}
		
		public static Mat loadImage(String imagePath) {
		    Imgcodecs imageCodecs = new Imgcodecs();
		    return imageCodecs.imread(imagePath);
		}
}
