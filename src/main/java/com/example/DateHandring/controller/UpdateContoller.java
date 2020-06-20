package com.example.DateHandring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DateHandring.domain.DateFormula;
import com.example.DateHandring.domain.SimulationForm;
import com.example.DateHandring.service.DateHandringService;

@Controller
@RequestMapping("/update/{id}")
public class UpdateContoller {

	@Autowired
	private DateHandringService service;

//	@GetMapping("/update/{id}")
	@GetMapping
	public String index(@PathVariable String id, Model model) {
		model.addAttribute("dateFormula", service.search(id));
		return "DateUpdate";
	}

//	@PostMapping("/update/{id}")
	@PostMapping
	public String update(@ModelAttribute @Validated DateFormula dataFormula, BindingResult bindingresult, Model model) {
		if(bindingresult.hasErrors()) {
			return "DateUpdate";
		}

		System.out.println("★update");
		service.update(dataFormula);
		model.addAttribute("simulationForm", new SimulationForm());
		return "DateHandring";
	}
}
