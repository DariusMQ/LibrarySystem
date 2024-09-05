package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.ejb.BooksBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DeclareRoles({"READ_BOOKS","WRITE_BOOKS"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed =
                {"WRITE_BOOKS"})})
@WebServlet(name = "Books", value = "/Books")
public class Books extends HttpServlet {

    @Inject
    BooksBean booksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookDto> books = booksBean.findAllBooks();
        List<BookDto> unavailableBooks = new ArrayList<>(books);
        booksBean.removeUnavailableBooks(books);
        booksBean.removeAvailableBooks(unavailableBooks);

        request.setAttribute("books",books);
        request.setAttribute("unavailablebooks",unavailableBooks);
        request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("deleteThis"));

        booksBean.deleteBook(bookId);

        response.sendRedirect(request.getContextPath()+"/Books");
    }
}