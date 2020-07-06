package com.example.DateHandring.domain.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.DateHandring.domain.dto.User;

@Dao
@ConfigAutowireable
@Repository
public interface UserDao {
    /**
     * ユーザーを取得します。
     */
    @Select
    List<User> selectAll();

    @Select
    Optional<User> select(User user);

    @Insert
    @Transactional
    int insert(User user);

}
