package com.example.DateHandring.domain;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 画面用の処理結果オブジェクト
 * @author tamurayuuya
 *
 */
public class Result {

	/** 日付計算式 */
	private DateFormula formula;
	/** 計算結果 */
	private String calculated;

	public Result(DateFormula formula) {
		this.formula = formula;
	}
	public String getId() {
		return formula.getId();
	}

	public String getName() {
		return formula.getName();
	}

	public int getYear() {
		return formula.getYear();
	}

	public int getMonth() {
		return formula.getMonth();
	}

	public int getDay() {
		return formula.getDay();
	}


//	 @return 日付計算式
	public DateFormula getFormula() {
		return formula;
	}

	/**
	 * @return 計算結果
	 */
	public String getCalculated() {
		return calculated;
	}

	public void setCalculated(String calculated) {
		this.calculated = calculated;
	}

	public String getYmdFormula() {
		int[] ymdFormula = {formula.getYear(),formula.getMonth(),formula.getDay()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(ymdFormula).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}

}
