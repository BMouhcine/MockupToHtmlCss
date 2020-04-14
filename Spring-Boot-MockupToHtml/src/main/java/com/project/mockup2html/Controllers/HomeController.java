package com.project.mockup2html.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {
	
	// Register Handler
		@GetMapping("/Portal")
	    ResponseEntity<String> createUser() {
	        return ResponseEntity.ok().body("rak f portal");
	    }
	
}
