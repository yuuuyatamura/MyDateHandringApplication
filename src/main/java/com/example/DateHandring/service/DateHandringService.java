package com.example.DateHandring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DateHandring.domain.DateFormula;
import com.example.DateHandring.repository.DateHandringRepository;

@Service
public class DateHandringService {

	@Autowired
	private DateHandringRepository repository;

	@Transactional
	public void register(DateFormula dateFormula) {
		repository.insert(dateFormula);

	}
	/**
	 * 日付計算式を取得します。
	 *
	 * @return 日付計算式
	 */
	public DateFormula search(String id) {
		return repository.selectPK(id);
	}


	public List<DateFormula> search() {
		return repository.select();
	}

	public String calculate(String baseDate, DateFormula formula) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate calculatedDate = date.plusYears(formula.getYear()).plusMonths(formula.getMonth()).plusDays(formula.getDay());
		return calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	@Transactional
	public void update(DateFormula dateFormula) {
		repository.update(dateFormula);
	}

	@Transactional
	public void delete(String id) {
		repository.deletePK(id);
		return;
	}

}
