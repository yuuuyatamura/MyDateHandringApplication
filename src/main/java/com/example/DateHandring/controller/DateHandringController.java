package com.example.DateHandring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "DateHandring";
	}


	@PostMapping("/")
	//バリデーションのチェック結果はBindoingResultクラスに入っている。
	public String index(@ModelAttribute @Validated SimulationForm form,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "DateHandring";
		}

		SimulationForm resultForm = new SimulationForm(form.getBaseDate(), service.search());
		List<Result> results = resultForm.getResults();

		results.stream().forEach(e -> e.setCalculated(service.calculate(form.getBaseDate(), e.getFormula())));
		model.addAttribute("results", results);
		return "DateHandring";
	}

	@PostMapping("/{id}")
	public String delete(@PathVariable String id, Model model) {
		service.delete(id);
		model.addAttribute("simulationForm", new SimulationForm());
		return "DateHandring";
	}
}
