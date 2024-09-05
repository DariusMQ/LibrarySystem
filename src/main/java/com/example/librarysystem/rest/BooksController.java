package com.example.librarysystem.rest;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.ejb.BooksBean;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@RolesAllowed("READ_BOOKS")
@Path("/books")
public class BooksController {
    @Inject
    BooksBean booksBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDto> findAllBooks(){
        return booksBean.findAllBooks();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookDto findBook(@PathParam("id") Long id){
        return booksBean.findBookById(id);
    }
}
