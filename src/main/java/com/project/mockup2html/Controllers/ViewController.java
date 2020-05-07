package com.project.mockup2html.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {
	
	//Login Register Handler
		@GetMapping("/error")
	    public String portalAngularHandler() {
	        return "<h2>Cannot Access this URL</h2>";
		}
		
	
}
