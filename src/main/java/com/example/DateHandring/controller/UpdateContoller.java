//package com.example.DateHandring.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.example.DateHandring.service.DateHandringService;
//
//
//
//@Controller
//public class UpdateContoller {
//
//	@Autowired
//	private DateHandringService service;
//
//	@RequestMapping(value = "/date/update",method = RequestMethod.GET)
//	public String index(@PathVariable String dateId, Model model) {
//		model.addAttribute("dateFormula", service.search(dateId));
//		return "DateUpdate";
//	}
//}
