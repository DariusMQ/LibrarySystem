package com.example.librarysystem.ejb;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.entities.Book;
import com.example.librarysystem.entities.Borrowed_Book;
import com.example.librarysystem.entities.Returned_Book;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BooksBean {
    public static final Logger LOG = Logger.getLogger(BooksBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<BookDto> findAllBooks() {
        LOG.info("findAllCars");

        try {
            TypedQuery<Book> typedQuery = entityManager.createQuery("SELECT b FROM Book b", Book.class);

            List<Book> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        }

        catch (Exception ex) {
            throw new EJBException(ex);
        }

    }

    public List<BookDto> copyBooksToDto(List<Book> Books) {

        List<BookDto> BookDtos = new ArrayList<>();

        for (Book book : Books) {

            List<Long> ids = new ArrayList<>();

            for (Borrowed_Book bbook : book.getBorrowedBooks()) {
                ids.add(bbook.getId());
            }

            List<Long> rids = new ArrayList<>();

            for (Returned_Book rbook : book.getReturnedBooks()){
                rids.add(rbook.getId());
            }

            BookDto bookDto = new BookDto(book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getNumberOfPages(),
                    book.getCode(),
                    book.getQuantityAvailable(),
                    book.getPublishingDate(),
                    book.getLocation(),
                    ids,
                    rids);  //I swear to christ if it doesn't work this time...
            BookDtos.add(bookDto);
        }

        return BookDtos;
    }
}
