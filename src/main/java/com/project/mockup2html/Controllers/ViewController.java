package com.project.mockup2html.Controllers;


import java.awt.print.Printable;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import nu.pattern.OpenCV;


@Controller
public class ViewController {
	
	//Login Register Handler
		@GetMapping("/login")
	    public String portalAngularHandler() {
			OpenCV.loadShared();
			System.out.println("loooooooooooooooooooooooooooooooooooooooooool");
	        return "forward:./index.html";
		}
		
		
}
