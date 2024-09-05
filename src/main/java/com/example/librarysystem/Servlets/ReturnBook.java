package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.common.Borrowed_BookDto;
import com.example.librarysystem.ejb.BooksBean;
import com.example.librarysystem.ejb.Borrowed_BooksBean;
import com.example.librarysystem.ejb.Returned_BooksBean;
import com.example.librarysystem.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ReturnBook", value = "/ReturnBook")
public class ReturnBook extends HttpServlet {
    @Inject
    Returned_BooksBean returnedBooksBean;
    @Inject
    Borrowed_BooksBean borrowedBooksBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("id"));
        Borrowed_BookDto book = borrowedBooksBean.findBorrowedBookById(bookId);
        request.setAttribute("book",book);

        request.setAttribute("today", LocalDate.now());

        request.getRequestDispatcher("/WEB-INF/pages/returnBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long borrowedBookId = Long.parseLong(request.getParameter("bookId"));

        returnedBooksBean.returnBook(borrowedBookId);

        response.sendRedirect(request.getContextPath()+"/Profile");
    }
}