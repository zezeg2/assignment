package com.example.practice7.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String password;
    private boolean isAdmin;
}
