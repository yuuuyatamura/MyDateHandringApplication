package com.example.DateHandring.domain.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.springframework.data.annotation.Id;

import com.example.DateHandring.domain.dto.common.DomaDtoImpl;

import org.seasar.doma.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User extends DomaDtoImpl {
    //自動採番設定
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    String email;

    @Column
    String password;
}
