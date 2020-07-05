package com.example.DateHandring.web.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class LoginForm implements Serializable {

    private static final long serialVersionUID = 7593564324192730932L;

    @NotEmpty
    String userId;

    @NotEmpty
    String password;

    // ログインしたままにするか
    boolean rememberMe;
}