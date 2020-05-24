package com.example.DateHandring.domain;

import lombok.Data;

//@Data付けてるからgetter、setterいらない

@Data
public class DateFormula {

	public DateFormula() {}

	private int id;
	private String name;
	private int year;
	private int month;
	private int day;
}
