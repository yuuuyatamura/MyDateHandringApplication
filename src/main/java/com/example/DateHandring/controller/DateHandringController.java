package com.example.DateHandring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DateHandring.domain.Result;
import com.example.DateHandring.domain.SimulationForm;
import com.example.DateHandring.service.DateHandringService;

@Controller
//@RequestMapping("/date/handring")
public class DateHandringController {

	@Autowired
	private DateHandringService service;

//日付登録画面に遷移
	@GetMapping("/")
	public String postHandringRequest(@ModelAttribute SimulationForm form) {
		System.out.println("画面の初期表示");
		return "DateHandring";
	}


	@PostMapping("/")
	public String index(@ModelAttribute @Validated SimulationForm form,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "DateHandring";
		}

		SimulationForm resultForm = new SimulationForm(form.getBaseDate(), service.search());
//		System.out.println("確認①" + resultForm);
		List<Result> result = resultForm.getResults();
//		System.out.println("確認②" + result);

		result.stream().forEach(e -> e.setCalculated(service.calculate(form.getBaseDate(), e.getFormula())));
//		System.out.println("確認③");
		model.addAttribute("result", result);
		return "DateHandring";
	}
}
