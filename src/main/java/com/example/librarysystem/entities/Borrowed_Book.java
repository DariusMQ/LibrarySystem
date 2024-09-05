package com.example.librarysystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Borrowed_Book {
    @Id
    @GeneratedValue
    private Long id;
    private Date borrowDate;
    private Date toBeReturnedDate;
    private Date returnDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getToBeReturnedDate() {
        return toBeReturnedDate;
    }

    public void setToBeReturnedDate(Date toBeReturnedDate) {
        this.toBeReturnedDate = toBeReturnedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
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
