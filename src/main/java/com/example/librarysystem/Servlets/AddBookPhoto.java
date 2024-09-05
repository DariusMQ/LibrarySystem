package com.example.librarysystem.Servlets;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.ejb.BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@MultipartConfig
@WebServlet(name = "AddBookPhoto", value = "/AddBookPhoto")
public class AddBookPhoto extends HttpServlet {

    @Inject
    BooksBean booksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("id"));
        BookDto book = booksBean.findBookById(bookId);
        request.setAttribute("book",book);

        request.getRequestDispatcher("/WEB-INF/pages/addBookPhoto.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("book_id"));

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        booksBean.addPhotoToBook(bookId,fileName,fileType,fileContent);
        response.sendRedirect(request.getContextPath()+"/Books");
    }
}