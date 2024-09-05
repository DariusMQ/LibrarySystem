package com.example.librarysystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Borrowed_Book {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate borrowDate;
    private LocalDate toBeReturnedDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getToBeReturnedDate() {
        return toBeReturnedDate;
    }

    public void setToBeReturnedDate(LocalDate toBeReturnedDate) {
        this.toBeReturnedDate = toBeReturnedDate;
    }


    @ManyToOne
    private User borrower;

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    @ManyToOne
    private Book book;

    public Book getBook(){
        return book;
    }

    public void setBook(Book book){
        this.book = book;
    }
}
