package com.example.DateHandring.web.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserForm implements Serializable {
    Long id;

    @NotEmpty
    String name;

    @NotEmpty
    String userId;

    @NotEmpty
    String password;

    @NotEmpty
    String passwordConfirm;
}