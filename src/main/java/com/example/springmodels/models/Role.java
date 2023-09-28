package com.example.springmodels.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.*;
public enum Role implements GrantedAuthority {
    USER, ADMIN;
    @Override
    public String getAuthority()
    {
        return name();
    }
}