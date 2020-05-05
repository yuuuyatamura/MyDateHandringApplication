package com.example.DateHandring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DateHandring.domain.DateFormula;
import com.example.DateHandring.service.DateHandringService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DateHandringController {

	/**
	 * 日付計算処理
	 */
//	@Autowired
//	private com.example.DateHandring.service.DateHandringService service;

	@RequestMapping(value = "/date",method = RequestMethod.GET)
	public String getDate() {
		return "DateRegister";
	}

	@RequestMapping(value = "DateRegister", method = RequestMethod.POST)
	public String postRequest(@ModelAttribute("dateFormula") DateFormula dateFormula) {
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
