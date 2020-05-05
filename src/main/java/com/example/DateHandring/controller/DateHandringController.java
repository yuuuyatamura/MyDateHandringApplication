package com.example.DateHandring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DateHandring.domain.CalculateForm;
import com.example.DateHandring.domain.DateFormula;
import com.example.DateHandring.service.DateHandringService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DateHandringController {

	/**
	 * 日付計算処理
	 */
	@Autowired
	private DateHandringService service;

//	@RequestMapping(value = "/date",method = RequestMethod.GET)
	@GetMapping("/date")
	public String index() {
		return "DateRegister";
	}

//日付計算画面に遷移
	//TODO：計算に応じてエラー文言出す
//	@RequestMapping(value = "DateRegister", method = RequestMethod.POST)
	@PostMapping("/date")
	public String register(@ModelAttribute("dateFormula") DateFormula dateFormula, Model model) {
		service.register(dateFormula);
		model.addAttribute("calculateForm", new CalculateForm());
		return "DateHandring";
	}

//日付登録画面に遷移
	@GetMapping("/date/handring")
	public String create(CalculateForm calform, Model model) {
		model.addAttribute("CalculateForm",calform);
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
