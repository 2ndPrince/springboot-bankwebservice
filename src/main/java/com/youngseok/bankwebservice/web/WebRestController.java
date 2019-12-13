package com.youngseok.bankwebservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

	@GetMapping("")
	public String home() {
		return "welcome home";
	}
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "hello, " + name;
	}
}
