package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.ejb.BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Books", value = "/Books")
public class Books extends HttpServlet {

    @Inject
    BooksBean booksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookDto> books = booksBean.findAllBooks();
        request.setAttribute("books",books);
        request.setAttribute("numberOfBooks",books.size());
        request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("deleteThis"));

        booksBean.deleteBook(bookId);

        response.sendRedirect(request.getContextPath()+"/Books");
    }
}