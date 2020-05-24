package com.example.DateHandring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DateHandring.service.DateHandringService;

@Controller
@RequestMapping("/update/{dateId}")
public class UpdateContoller {

	@Autowired
	private DateHandringService service;

	@GetMapping("/update")
	public String index(@PathVariable String id, Model model) {
		model.addAttribute("dataFormula", service.search(id));
		return "DateUpdate";
	}
	@PostMapping("/update")
	public String postUpdate() {

		return "DateUpdate";
	}
}
