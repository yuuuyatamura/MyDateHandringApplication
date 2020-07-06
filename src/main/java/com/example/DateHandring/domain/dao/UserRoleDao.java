package com.example.DateHandring.domain.dao;

import java.util.stream.Collector;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.stereotype.Repository;

import com.example.DateHandring.domain.dto.UserRole;

@ConfigAutowireable
@Dao
@Repository // <- 追加
public interface UserRoleDao {

    @Select
    String selectByUserId(Long id);

    /**
     * 権限を取得します。
     *
     * @param id
     * @param collector
     * @param <R>
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R selectByUserId(Long id, final Collector<UserRole, ?, R> collector);

    @Insert(exclude = {"roleName", "permissionKey", "permissionName"})
    int insert(UserRole userRole);
}
