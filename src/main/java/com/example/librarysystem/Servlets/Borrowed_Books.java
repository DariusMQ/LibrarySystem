package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.Borrowed_BookDto;
import com.example.librarysystem.ejb.Borrowed_BooksBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@DeclareRoles({"READ_BORROWED_BOOKS","WRITE_BORROWED_BOOKS"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_BORROWED_BOOKS"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed =
                {"WRITE_BORROWED_BOOKS"})})
@WebServlet(name = "Borrowed_Books", value = "/Borrowed_Books")
public class Borrowed_Books extends HttpServlet {

    @Inject
    Borrowed_BooksBean borrowedBooksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Borrowed_BookDto> borrowedBooks = borrowedBooksBean.findAllBorrowedBooks();
        request.setAttribute("borrowedBooks",borrowedBooks);
        request.getRequestDispatcher("/WEB-INF/pages/borrowedbooks.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}