package com.example.DateHandring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DateHandring.domain.DateFormula;

@Service
public class DateHandringServiceImpl implements DateHandringService {

	private DateHandringDAO dao;

	@Autowired
	public void DateHandringDAOImpl(DateHandringDAO dao) {
		this.dao = dao;
	}
	public void insert(DateFormula dateFormula) {
		dao.insert(dateFormula);

	}

}
