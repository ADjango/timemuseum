package com.example.myazureapp.entity;

public enum UserRole {
    USER,

    MODERATOR,

    ADMIN;

    public UserRole[] getDefaultRoles(){
        return new UserRole[]{USER};
    }
}
