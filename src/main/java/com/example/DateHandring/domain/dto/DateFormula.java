package com.example.DateHandring.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

//@Data付けてるからgetter、setterいらない

@Data
public class DateFormula {

	public DateFormula() {}
	@NotBlank
	@Length(min = 1,max = 4)
	private String id;
	@NotBlank
	private String name;
	@NotNull
	private int year;
	@NotNull
	private int month;
	@NotNull
	private int day;
}
