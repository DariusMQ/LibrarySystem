package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.ejb.BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_BOOKS"}))
@WebServlet(name = "EditBook", value = "/EditBook")
public class EditBook extends HttpServlet {
    @Inject
    BooksBean booksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("id"));
        BookDto book = booksBean.findBookById(bookId);
        request.setAttribute("book",book);

        request.getRequestDispatcher("/WEB-INF/pages/editBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("bookId"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Long numberOfPages = Long.parseLong(request.getParameter("pages"));
        Long code = Long.parseLong(request.getParameter("code"));
        Long quantity = Long.parseLong(request.getParameter("quantity"));
        LocalDate publishingDate = LocalDate.parse(request.getParameter("publishingDate"));

        booksBean.updateBook(bookId,title,author,numberOfPages,code,quantity,publishingDate);

        response.sendRedirect(request.getContextPath()+"/Books");
    }
}