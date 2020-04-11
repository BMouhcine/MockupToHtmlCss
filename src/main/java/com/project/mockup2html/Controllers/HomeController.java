package com.project.mockup2html.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homeHandler() {
		System.out.println("We're testing home controller");
		return "index";
	}
}
