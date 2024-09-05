package com.example.librarysystem.Servlets;

import com.example.librarysystem.ejb.BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_BOOKS"}))
@WebServlet(name = "AddBook", value = "/AddBook")
public class AddBook extends HttpServlet {
    @Inject
    BooksBean booksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Long numberOfPages = Long.parseLong(request.getParameter("pages"));
        Long code = Long.parseLong(request.getParameter("code"));
        Long quantityAvailable = Long.parseLong(request.getParameter("quantity"));
        LocalDate publishingDate = LocalDate.parse(request.getParameter("publishingDate"));
        String location = request.getParameter("location");

        booksBean.createBook(title,author,numberOfPages,code,quantityAvailable,publishingDate,location);

        response.sendRedirect(request.getContextPath()+"/Books");
    }
}