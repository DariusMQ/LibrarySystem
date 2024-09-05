package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.ejb.BooksBean;
import com.example.librarysystem.ejb.Borrowed_BooksBean;
import com.example.librarysystem.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "BorrowBook", value = "/BorrowBook")
public class BorrowBook extends HttpServlet {

    @Inject
    BooksBean booksBean;

    @Inject
    UsersBean usersBean;

    @Inject
    Borrowed_BooksBean borrowedBooksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("id"));
        BookDto book = booksBean.findBookById(bookId);
        request.setAttribute("book",book);

        request.setAttribute("today", LocalDate.now());

        request.getRequestDispatcher("/WEB-INF/pages/borrowBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("bookId"));
        Long borrowerId = usersBean.findUserByUsername(request.getParameter("userId")).getId();
        LocalDate toBeReturnedDate = LocalDate.parse(request.getParameter("returnDate"));

        borrowedBooksBean.borrowBook(bookId,borrowerId,toBeReturnedDate);

        response.sendRedirect(request.getContextPath()+"/Books");
    }
}