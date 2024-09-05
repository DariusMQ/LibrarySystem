package com.example.librarysystem.common;

import constants.enums;

import java.time.LocalDate;

public class Returned_BookDto {
    Long id;
    LocalDate borrowDate;
    LocalDate toBeReturnedDate;
    LocalDate returnDate;
    String borrowerUsername;
    String bookTitle;
    enums.ReturnStatus returnStatus;

    public Returned_BookDto(Long id,
                            LocalDate borrowDate,
                            LocalDate toBeReturnedDate,
                            LocalDate returnDate,
                            String borrowerUsername,
                            String bookTitle)
    {
        this.id = id;
        this.borrowDate = borrowDate;
        this.toBeReturnedDate = toBeReturnedDate;
        this.returnDate = returnDate;
        this.borrowerUsername = borrowerUsername;
        this.bookTitle = bookTitle;

        if(returnDate.isAfter(toBeReturnedDate)){
            returnStatus = enums.ReturnStatus.RETURNED_LATE;
        }
        else {
            returnStatus = enums.ReturnStatus.RETURNED_IN_TIME;
        }
    }

    public Long getId() {
        return id;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getToBeReturnedDate() {
        return toBeReturnedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getBorrowerUsername() {
        return borrowerUsername;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public enums.ReturnStatus getReturnStatus() {
        return returnStatus;
    }
}
