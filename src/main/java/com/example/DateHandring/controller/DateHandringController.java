package com.example.DateHandring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.DateHandring.domain.CalculateForm;
import com.example.DateHandring.domain.DateFormula;
import com.example.DateHandring.service.DateHandringService;

@Controller
public class DateHandringController {

	/**
	 * 日付計算処理
	 */
	@Autowired
	private DateHandringService service;

////	@RequestMapping(value = "/date",method = RequestMethod.GET)
//	@GetMapping("/date")
//	public String index() {
//		return "DateRegister";
//	}

//日付計算画面に遷移
	//TODO：計算に応じてエラー文言出す
	@GetMapping("/date")
	public String index(@ModelAttribute("dateFormula") DateFormula dateFormula, Model model) {
//		service.create(dateFormula);
		model.addAttribute("calculateForm", new CalculateForm());
		return "DateHandring";
	}

//日付登録画面に遷移
	@PostMapping("/date/handring")
	public String create(@ModelAttribute CalculateForm calform, Model model, RedirectAttributes redirectAttributes) {

		DateFormula dateFormula = new DateFormula();
		dateFormula.setDateId(dateFormula.getDateId());
		dateFormula.setDateName(dateFormula.getDateName());
		dateFormula.setAdjustmentYear(dateFormula.getAdjustmentYear());
		dateFormula.setAdjustmentMonth(dateFormula.getAdjustmentMonth());
		dateFormula.setAdjustmentDay(dateFormula.getAdjustmentDay());

		service.insert(dateFormula);
		redirectAttributes.addFlashAttribute("sucsess", "登録が成功しました");

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
