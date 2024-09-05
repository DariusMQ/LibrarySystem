package com.example.librarysystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private Long numberOfPages;
    private Long code;
    private Long quantityAvailable;
    private LocalDate publishingDate;
    private String location;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Long quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "book")
    private Collection<Borrowed_Book> borrowedBooks;

    public Collection<Borrowed_Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Collection<Borrowed_Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @OneToMany(mappedBy = "book")
    private Collection<Returned_Book> returnedBooks;

    public Collection<Returned_Book> getReturnedBooks() {
        return returnedBooks;
    }

    public void setReturnedBooks(Collection<Returned_Book> returnedBooks) {
        this.returnedBooks = returnedBooks;
    }

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BookPhoto photo;

    public BookPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(BookPhoto photo) {
        this.photo = photo;
    }
}
