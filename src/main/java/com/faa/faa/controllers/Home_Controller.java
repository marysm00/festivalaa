package com.faa.faa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class Home_Controller {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/informacion")
	public String info() {
		return "informacion";
	}

}