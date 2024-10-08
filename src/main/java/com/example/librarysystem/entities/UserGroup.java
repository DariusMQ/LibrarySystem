package com.example.librarysystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserGroup {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String usergroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String userGroup) {
        this.usergroup = userGroup;
    }
}
