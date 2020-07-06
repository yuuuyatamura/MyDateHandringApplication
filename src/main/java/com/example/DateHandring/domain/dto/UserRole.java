package com.example.DateHandring.domain.dto;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

import com.example.DateHandring.domain.dto.common.DefaultEntityListener;
import com.example.DateHandring.domain.dto.common.DomaDtoImpl;

import lombok.Data;

@Entity(listener = DefaultEntityListener.class)
@Data
public class UserRole extends DomaDtoImpl{

	@Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //ユーザID
    Long user_id;

    //役割キー
    String role_key;

    //役割名
    String roleName;

    // 権限キー
    String permissionKey;

    // 権限名
    String permissionName;

}
