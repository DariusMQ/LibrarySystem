package com.example.librarysystem.ejb;

import com.example.librarysystem.common.Borrowed_BookDto;
import com.example.librarysystem.entities.Borrowed_Book;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class Borrowed_BooksBean {
    public static final Logger LOG = Logger.getLogger(Borrowed_BooksBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<Borrowed_BookDto> findAllBorrowedBooks(){

        try {
            TypedQuery<Borrowed_Book> typedQuery = entityManager.createQuery("SELECT bb FROM Borrowed_Book bb", Borrowed_Book.class);

            List<Borrowed_Book> bbooks = typedQuery.getResultList();
            return copyBorrowedBooksToDto(bbooks);
        }

        catch (Exception ex) {
            throw new EJBException(ex);
        }

    }

    public List<Borrowed_BookDto> copyBorrowedBooksToDto(List<Borrowed_Book> Bbooks) {

        List<Borrowed_BookDto> Borrowed_BookDtos = new ArrayList<>();

        for (Borrowed_Book bbook : Bbooks) {

            Borrowed_BookDto borrowedBook = new Borrowed_BookDto(
                    bbook.getId(),
                    bbook.getBorrowDate(),
                    bbook.getToBeReturnedDate(),
                    bbook.getBorrower().getUsername(),
                    bbook.getBook().getTitle()
            );

            Borrowed_BookDtos.add(borrowedBook);
        }

        return Borrowed_BookDtos;
    }

    public List<Borrowed_BookDto> findBorrowedBooksByBookId(Long bookId){
        try{
            TypedQuery<Borrowed_Book> typedQuery = entityManager.createQuery("SELECT bb FROM Borrowed_Book bb WHERE bb.book.id = "+bookId, Borrowed_Book.class);

            List<Borrowed_Book> bbooks = typedQuery.getResultList();
            return copyBorrowedBooksToDto(bbooks);
        }

        catch (Exception ex) {
            throw new EJBException(ex);
        }

    }

    public void deleteBorrowedBooks(List<Borrowed_BookDto> bbooks){
        for(Borrowed_BookDto bbook: bbooks){
            Borrowed_Book book = entityManager.find(Borrowed_Book.class,bbook.getId());
            entityManager.remove(book);
        }
    }
}
