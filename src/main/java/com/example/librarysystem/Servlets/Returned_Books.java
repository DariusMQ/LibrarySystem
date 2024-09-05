package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.Returned_BookDto;
import com.example.librarysystem.ejb.Returned_BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Returned_Books", value = "/Returned_Books")
public class Returned_Books extends HttpServlet {

    @Inject
    Returned_BooksBean returnedBooksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Returned_BookDto> returnedBooks = returnedBooksBean.findAllReturnedBooks();
        request.setAttribute("returnedBooks",returnedBooks);
        request.getRequestDispatcher("/WEB-INF/pages/returnedbooks.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}