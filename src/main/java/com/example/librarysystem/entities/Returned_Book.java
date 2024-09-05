package com.example.librarysystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Returned_Book {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate borrowDate;
    private LocalDate toBeReturnedDate;
    private LocalDate returnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
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
