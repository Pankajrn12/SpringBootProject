package com.library.libraryManagement.services;

import com.library.libraryManagement.entities.Book;
import com.library.libraryManagement.models.BookModel;
import com.library.libraryManagement.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    EntityManager entityManager;
    @Transactional
    public ResponseEntity saveBookDetails(BookModel bookModel) {
        Book book = new Book();
        book.setBookName(bookModel.getBookName());
        book.setBookPrice(bookModel.getBookPrice());
        book.setBookAuthorName(bookModel.getBookAuthorName());
        book.setBookEdition(bookModel.getBookEdition());
        bookRepository.save(book);
        return new ResponseEntity<>("data saved", HttpStatus.OK);
    }

    public List<BookModel> getAllBookDetails() {
        List<BookModel> modelList= new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        bookList.stream().forEach(data->{
            BookModel bookModel = new BookModel();
            bookModel.setBookId(data.getBookId());
            bookModel.setBookAuthorName(data.getBookAuthorName());
            bookModel.setBookEdition(data.getBookEdition());
            bookModel.setBookName(data.getBookName());
            bookModel.setBookPrice(data.getBookPrice());

            modelList.add(bookModel);
        });
        return  modelList;
    }

    public ResponseEntity deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
        return new ResponseEntity<>("Data is Deleted", HttpStatus.OK);
    }

    public ResponseEntity updateBookDetailsById(BookModel bookModel) {
        entityManager.createNativeQuery("update book set book_author_name =:authorName, book_name =:bookName, book_price =:bookPrice where book_id =:bookId ")
                .setParameter("authorName", bookModel.getBookAuthorName())
                .setParameter("bookName",bookModel.getBookName())
                .setParameter("bookPrice",bookModel.getBookPrice())
                .setParameter("bookId",bookModel.getBookId()).executeUpdate();
        return new ResponseEntity<>("Data is Updeted", HttpStatus.OK);
    }
}
