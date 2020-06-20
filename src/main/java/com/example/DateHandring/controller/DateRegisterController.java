package com.example.DateHandring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.DateHandring.domain.DateFormula;
import com.example.DateHandring.domain.SimulationForm;
import com.example.DateHandring.service.DateHandringService;

@Controller
public class DateRegisterController {

	@Autowired
	private DateHandringService service;

//	@RequestMapping(value = "/date",method = RequestMethod.GET)
	@GetMapping("/register")
	public String index(@ModelAttribute DateFormula form) {
		return "DateRegister";
	}

//日付計算画面に遷移
	@PostMapping("/register")
	public String create(@ModelAttribute @Validated DateFormula dateFormula, BindingResult bindingresult, Model model, RedirectAttributes redirectAttributes) {
		if(bindingresult.hasErrors()) {
			return "DateRegister";
		}
		service.register(dateFormula);
		model.addAttribute("simulationForm", new SimulationForm());
		return "DateUpdate";
	}
}
