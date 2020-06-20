//package com.example.DateHandring.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.example.DateHandring.domain.DateFormula;
//
////データベースを操作するクラス
//@Repository
//public class DateHandringDAOImpl implements DateHandringDAO {
//
//	private final JdbcTemplate jdbcTemplate;
//
//	@Autowired
//	public DateHandringDAOImpl(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	//新規登録
//	@Override
//	public void insert(DateFormula dateFomura) {
//		jdbcTemplate.update("INSERT INTO date_user(dateId, dateName, adjustmentYear, adjustmentMonth, adjustmentDay) VALUES (?,?,?,?,?)",
//		dateFomura.getDateId(),dateFomura.getDateName(),dateFomura.getAdjustmentYear(),dateFomura.getAdjustmentMonth(),dateFomura.getAdjustmentDay());
//	}
//
//	@Override
//	public int update(DateFormula dateFomura) {
//		// TODO 自動生成されたメソッド・スタブ
//		return 0;
//	}
//
//	@Override
//	public int delete(String id) {
//		// TODO 自動生成されたメソッド・スタブ
//		return 0;
//	}
//
//}
