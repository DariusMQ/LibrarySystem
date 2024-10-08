package com.example.librarysystem.ejb;

import com.example.librarysystem.common.BookDto;
import com.example.librarysystem.common.BookPhotoDto;
import com.example.librarysystem.common.Borrowed_BookDto;
import com.example.librarysystem.common.Returned_BookDto;
import com.example.librarysystem.entities.Book;
import com.example.librarysystem.entities.BookPhoto;
import com.example.librarysystem.entities.Borrowed_Book;
import com.example.librarysystem.entities.Returned_Book;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BooksBean {
    public static final Logger LOG = Logger.getLogger(BooksBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Returned_BooksBean returnedBooksBean;
    @Inject
    Borrowed_BooksBean borrowedBooksBean;

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
                    rids);
            BookDtos.add(bookDto);
        }

        return BookDtos;
    }

    public void createBook(String title,
                           String author,
                           Long numberOfPages,
                           Long code,
                           Long quantityAvailable,
                           LocalDate publishingDate,
                           String location)
    {
        LOG.info("createBook");

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setNumberOfPages(numberOfPages);
        book.setCode(code);
        book.setQuantityAvailable(quantityAvailable);
        book.setPublishingDate(publishingDate);
        book.setLocation(location);

        entityManager.persist(book);
    }

    public BookDto findBookById(Long bookId) {
        for(BookDto bookDto:  findAllBooks()){
            if(bookId.equals(bookDto.getId()))
                return bookDto;
        }
        return null;
    }

    public void updateBook(Long bookId,
                           String title,
                           String author,
                           Long numberOfPages,
                           Long code,
                           Long quantityAvailable,
                           LocalDate publishingDate){
        LOG.info("updateBook");

        Book book = entityManager.find(Book.class,bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setNumberOfPages(numberOfPages);
        book.setCode(code);
        book.setQuantityAvailable(quantityAvailable);
        book.setPublishingDate(publishingDate);
    }

    public void deleteBook(Long bookId){
        LOG.info("deleteBook");

        List<Borrowed_BookDto> bbooks = borrowedBooksBean.findBorrowedBooksByBookId(bookId);
        borrowedBooksBean.deleteBorrowedBooks(bbooks);

        List<Returned_BookDto> rbooks = returnedBooksBean.findReturnedBooksByBookId(bookId);
        returnedBooksBean.deleteReturnedBooks(rbooks);

        Book book = entityManager.find(Book.class,bookId);
        entityManager.remove(book);
    }

    public void addPhotoToBook(Long bookId, String filename, String fileType, byte[] fileContent) {
        LOG.info("addPhotoToBook");
        BookPhoto photo = new BookPhoto();
        photo.setFilename(filename);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        Book book = entityManager.find(Book.class, bookId);
        if (book.getPhoto() != null) {
            entityManager.remove(book.getPhoto());
        }
        book.setPhoto(photo);
        photo.setBook(book);
        entityManager.persist(photo);
    }
    public BookPhotoDto findPhotoByBookId(Integer bookId) {
        List<BookPhoto> photos = entityManager
                .createQuery("SELECT p FROM BookPhoto p where p.book.id = :id", BookPhoto.class)
                .setParameter("id", bookId)
                .getResultList();
        if (photos.isEmpty()) {
            return null;
        }
        BookPhoto photo = photos.get(0); // the first element
        return new BookPhotoDto(photo.getId(), photo.getFilename(), photo.getFileType(),
                photo.getFileContent());
    }

    public void removeUnavailableBooks(List<BookDto> books){
        List<BookDto> toBeRemoved = new ArrayList<>();
        for (BookDto book: books){
            if(book.getQuantityAvailable()==0){
                toBeRemoved.add(book);
            }
        }
        books.removeAll(toBeRemoved);
    }

    public void removeAvailableBooks(List<BookDto> books){
        List<BookDto> toBeRemoved = new ArrayList<>();
        for (BookDto book: books){
            if(book.getQuantityAvailable()!=0){
                toBeRemoved.add(book);
            }
        }
        books.removeAll(toBeRemoved);
    }
}
