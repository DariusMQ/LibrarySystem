package com.example.librarysystem.common;

import com.example.librarysystem.entities.User;
import constants.enums;

import java.time.LocalDate;
import java.util.Date;

public class Borrowed_BookDto {
     Long id;
     LocalDate borrowDate;
     LocalDate toBeReturnedDate;
     String borrowerUsername;
     String bookTitle;

     public Borrowed_BookDto(Long id,
                             LocalDate borrowDate,
                             LocalDate toBeReturnedDate,
                             String borrowerUsername,
                             String bookTitle) {
          this.id = id;
          this.borrowDate = borrowDate;
          this.toBeReturnedDate = toBeReturnedDate;
          this.borrowerUsername = borrowerUsername;
          this.bookTitle = bookTitle;
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

     public String getBorrowerUsername() {
          return borrowerUsername;
     }

     public String getBookTitle() {
          return bookTitle;
     }

}
