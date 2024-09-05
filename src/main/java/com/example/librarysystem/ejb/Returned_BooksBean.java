package com.example.librarysystem.ejb;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.common.Borrowed_BookDto;
import com.example.librarysystem.common.Returned_BookDto;
import com.example.librarysystem.entities.Book;
import com.example.librarysystem.entities.Borrowed_Book;
import com.example.librarysystem.entities.Returned_Book;
import com.example.librarysystem.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class Returned_BooksBean {

    @Inject
    Borrowed_BooksBean borrowedBooksBean;
    @Inject
    BooksBean booksBean;

    public static final Logger LOG = Logger.getLogger(Returned_BooksBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<Returned_BookDto> findAllReturnedBooks(){

        try {
            TypedQuery<Returned_Book> typedQuery = entityManager.createQuery("SELECT rb FROM Returned_Book rb", Returned_Book.class);

            List<Returned_Book> rbooks = typedQuery.getResultList();
            return copyReturnedBooksToDto(rbooks);
        }

        catch (Exception ex) {
            throw new EJBException(ex);
        }

    }

    public List<Returned_BookDto> copyReturnedBooksToDto(List<Returned_Book> Rbooks) {

        List<Returned_BookDto> Returned_BookDtos = new ArrayList<>();

        for (Returned_Book rbook : Rbooks) {

            Returned_BookDto returnedBook = new Returned_BookDto(
                    rbook.getId(),
                    rbook.getBorrowDate(),
                    rbook.getToBeReturnedDate(),
                    rbook.getReturnDate(),
                    rbook.getBorrower().getUsername(),
                    rbook.getBook().getTitle()
            );

            Returned_BookDtos.add(returnedBook);
        }

        return Returned_BookDtos;
    }

    public void returnBook(Long borrowed_BookId){
        LOG.info("returnBook");

        Borrowed_Book borrowed_Book = entityManager.find(Borrowed_Book.class,borrowed_BookId);

        Book book = entityManager.find(Book.class,borrowed_Book.getBook().getId());
        book.setQuantityAvailable(book.getQuantityAvailable()+1);

        User user = entityManager.find(User.class,borrowed_Book.getBorrower().getId());

        Returned_Book returnedBook = new Returned_Book();
        returnedBook.setBorrowDate(borrowed_Book.getBorrowDate());
        returnedBook.setToBeReturnedDate(borrowed_Book.getToBeReturnedDate());
        returnedBook.setReturnDate(LocalDate.now());
        returnedBook.setBook(book);
        returnedBook.setBorrower(user);

        entityManager.persist(returnedBook);
        entityManager.remove(borrowed_Book);
    }

}
