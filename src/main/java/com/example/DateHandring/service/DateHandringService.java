package com.example.DateHandring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DateHandring.domain.DateFormula;
import com.example.DateHandring.repository.DateHandringRepository;

@Service
public class DateHandringService {

	@Autowired
	private DateHandringRepository repository;

	public void register(DateFormula dateFormula) {
		repository.insert(dateFormula);

	}

	public List<DateFormula> search(String id) {
		return repository.select();
	}

	public String calculate(String baseDate, DateFormula formula) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
//		System.out.println("date:"+ date);
		LocalDate calculatedDate = date.plusYears(formula.getYear()).plusMonths(formula.getMonth()).plusDays(formula.getDay());
//		System.out.println("calculatedDate.format(DateTimeFormatter.ofPattern(\"yyyyMMdd\"):" + calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		return calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

}
