package com.example.DateHandring.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.DateHandring.domain.DateFormula;


//@MapperScan(basePackages = {"com.example.DateHandring.service.DateHandringService"})
@Mapper
public interface DateHandringRepository {

	/**
	 * 日付計算式を更新します。
	 *
	 * @param formula 登録する日付計算式
	 */
	@Insert("INSERT INTO dateformula VALUES(#{id}, #{name}, #{year}, #{month}, #{day})")
	void insert(DateFormula formula);

	@Select("SELECT * FROM dateformula ORDER BY id ASC")
	List<DateFormula> select();
}
