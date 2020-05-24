package com.example.DateHandring.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 日付計算処理をシミュレートする画面を表現するフォームビーンです。
 *
 * @author koujienami
 */
public class SimulationForm {

	/** 計算基準日 */
	@NotBlank
	@Pattern(regexp = "((19|[2-9][0-9])[0-9]{2})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])")
	private String baseDate;
	/** 計算結果 */
	private List<Result> results;

	/**
	 * デフォルトコンストラクタ。
	 */
	public SimulationForm() {
	}

	/**
	 * コンストラクタ。
	 *
	 * @param baseDate 計算基準日
	 * @param results 日付計算式一覧
	 */
	public SimulationForm(String baseDate, List<DateFormula> results) {
		this.baseDate = baseDate;
		this.results = new ArrayList<>();
		results.stream().forEach(r -> this.results.add(convertToResult(r)));
	}

	/**
	 * 計算基準日を取得します。
	 *
	 * @return 計算基準日
	 */
	public String getBaseDate() {
		return baseDate;
	}

	/**
	 * 計算基準日を設定します。
	 *
	 * @param baseDate 計算基準日
	 */
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	/**
	 * 計算結果を取得します。
	 *
	 * @return 計算結果
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * 日付計算式の内容を画面用の計算結果オブジェクトに変換します。
	 *
	 * @param formula 日付計算式
	 * @return 画面用計算結果オブジェクト
	 */
	public Result convertToResult(DateFormula formula) {
		return new Result(formula);
	}
}