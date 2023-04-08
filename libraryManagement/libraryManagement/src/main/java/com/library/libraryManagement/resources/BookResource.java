package com.library.libraryManagement.resources;

import com.library.libraryManagement.models.BookModel;
import com.library.libraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/abc")
public class BookResource {
    @Autowired
    BookService bookService;
    @PostMapping("/saveBookDetails")
    public ResponseEntity saveBookDetails(@RequestBody BookModel bookModel){
        return bookService.saveBookDetails(bookModel);
    }

    @GetMapping("/getAllBookDetails")
    public List<BookModel> getAllBookDetails(){
        return bookService.getAllBookDetails();
    }

    @PostMapping("/deleteBookById/{bookId}")
    public ResponseEntity deleteBookById(@PathVariable("bookId") Long bookId){
        return bookService.deleteBookById(bookId);
    }

    @Transactional
    @PostMapping("/updateBookDetailsById")
    public ResponseEntity updateBookDetailsById(@RequestBody BookModel bookModel){
        return bookService.updateBookDetailsById(bookModel);
    }
}
