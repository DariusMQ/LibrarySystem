package com.example.librarysystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;

import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "borrower")
    private Collection<Borrowed_Book> borrowedBooks;

    public Collection<Borrowed_Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Collection<Borrowed_Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @OneToMany(mappedBy = "borrower")
    private Collection<Returned_Book> returnedBooks;

    public Collection<Returned_Book> getReturnedBooks() {
        return returnedBooks;
    }

    public void setReturnedBooks(Collection<Returned_Book> returnedBooks) {
        this.returnedBooks = returnedBooks;
    }
}
