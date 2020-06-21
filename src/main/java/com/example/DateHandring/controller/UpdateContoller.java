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
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String dataAccessExceptionHandler(SQLIntegrityConstraintViolationException e, Model model) {

		//例外クラスのメッセージをModelに登録
		model.addAttribute("error","内部サーバーエラー（DB） :ExceptionHandler");

		//例外クラスのメッセージをModelに登録
		model.addAttribute("message","UpdateControllerでSQLIntegrityConstraintViolationExceptionが発生しました。");

		//HTTPのエラーコード(500)をModelに登録
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		return "error";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {

		//例外クラスのメッセージをModelに登録
		model.addAttribute("error","内部サーバーエラー: ExceptionHandler");

		//例外クラスのメッセージをModelに登録
		model.addAttribute("message","UpdateControllerでExceptionが発生しました");

		//HTTPのエラーコード(500)をModelに登録
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

		return "error";
	}
}
