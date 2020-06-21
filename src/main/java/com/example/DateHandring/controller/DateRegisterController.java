package com.example.DateHandring.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String dataAccessExceptionHandler(SQLIntegrityConstraintViolationException e, Model model) {

		//例外クラスのメッセージをModelに登録
		model.addAttribute("error","内部サーバーエラー（DB） :ExceptionHandler");

		//例外クラスのメッセージをModelに登録
		model.addAttribute("message","DateRegisterControllerでSQLIntegrityConstraintViolationExceptionが発生しました。");

		//HTTPのエラーコード(500)をModelに登録
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		return "error";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {

		//例外クラスのメッセージをModelに登録
		model.addAttribute("error","内部サーバーエラー: ExceptionHandler");

		//例外クラスのメッセージをModelに登録
		model.addAttribute("message","DateregisteControllerでExceptionが発生しました");

		//HTTPのエラーコード(500)をModelに登録
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

		return "error";
	}
}
