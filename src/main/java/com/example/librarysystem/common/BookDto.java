package com.example.librarysystem.common;

import com.example.librarysystem.entities.Borrowed_Book;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class BookDto {
     Long id;
     String title;
     String author;
     Long numberOfPages;
     Long code;
     Long quantityAvailable;
     LocalDate publishingDate;
     String location;
     List<Long> borrowedBooksIds;
     List<Long> returnedBooksIds;

    public BookDto(Long id,
                   String title,
                   String author,
                   Long numberOfPages,
                   Long code,
                   Long quantityAvailable,
                   LocalDate publishingDate,
                   String location,
                   List<Long> borrowedBooksIds,
                   List<Long> returnedBooksIds)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.code = code;
        this.quantityAvailable = quantityAvailable;
        this.publishingDate = publishingDate;
        this.location = location;
        this.borrowedBooksIds = borrowedBooksIds;
        this.returnedBooksIds = returnedBooksIds;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public Long getCode() {
        return code;
    }

    public Long getQuantityAvailable() {
        return quantityAvailable;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public String getLocation() {
        return location;
    }

    public List<Long> getBorrowedBooksIds() {
        return borrowedBooksIds;
    }

    public List<Long> getReturnedBooksIds() {
        return returnedBooksIds;
    }
}
