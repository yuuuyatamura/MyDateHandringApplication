package com.example.Date.Handring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DateHandringController {

	@GetMapping("/date")
	public String getDate() {

		return "DateRegister";
	}

	@PostMapping("/date")
	public String postRequest() {

		return "DateRegister";
	}

	@GetMapping("/date/handring")
	public String getHandring() {
		return "DateHandring";
	}
	@PostMapping("/date/handring")
	public String postHandringRequest() {

		return "DateHandring";
	}

	@GetMapping("/date/update")
	public String getUpdate() {
		return "DateUpdate";
	}
	@PostMapping("/date/update")
	public String postUpdate() {

		return "DateUpdate";
	}
}
