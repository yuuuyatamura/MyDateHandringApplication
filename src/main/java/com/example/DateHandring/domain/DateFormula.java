package com.example.DateHandring.domain;

import lombok.Data;

//@Data付けてるからgetter、setterいらない

@Data
public class DateFormula {

	private int dateId;
	private String dateName;
	private int adjustmentYear;
	private int adjustmentMonth;
	private int adjustmentDay;
}
