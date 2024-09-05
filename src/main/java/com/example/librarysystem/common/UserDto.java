package com.example.librarysystem.common;

import java.util.List;

public class UserDto {
    Long id;
    String username;
    String password;
    String email;
    List<Long> borrowedBooksIds;

    public UserDto(Long id, String username, String password, String email, List<Long> borrowedBooksIds) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.borrowedBooksIds = borrowedBooksIds;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<Long> getBorrowedBooksIds() {
        return borrowedBooksIds;
    }
}
