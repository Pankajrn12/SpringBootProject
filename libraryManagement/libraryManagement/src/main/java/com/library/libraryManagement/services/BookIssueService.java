package com.library.libraryManagement.services;

import com.library.libraryManagement.entities.Book;
import com.library.libraryManagement.entities.BookIssue;
import com.library.libraryManagement.models.BookIssueModel;
import com.library.libraryManagement.repositories.BookIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service

public class BookIssueService {
    @Autowired
    BookIssueRepository bookIssueRepository;
    @Transactional
    public ResponseEntity saveIssueDetails(BookIssueModel bookIssueModel) {
        BookIssue bookIssue= new BookIssue();
        bookIssue.setBookId(bookIssueModel.getBookId());
        bookIssue.setStudentId(bookIssueModel.getStudentId());
        bookIssueRepository.save(bookIssue);
        return new ResponseEntity<>("Data Saved", HttpStatus.OK);
    }
    public List<BookIssueModel> getAllBookIssueDetails() {
        List<BookIssueModel> bookIssueModels = new ArrayList<>();
        List<BookIssue> bookIssues = bookIssueRepository.findAll();
        bookIssues.stream().forEach(data->{
            BookIssueModel bookIssueModel = new BookIssueModel();
            bookIssueModel.setBookIssueId(data.getBookIssueId());
            bookIssueModel.setBookId(data.getBookId());
            bookIssueModel.setStudentId(data.getStudentId());

            bookIssueModels.add(bookIssueModel);
        });

        return bookIssueModels;
    }

    public ResponseEntity deleteBookIssueById(Long bookIssueId) {
        bookIssueRepository.deleteById(bookIssueId);
        return new ResponseEntity<>("Data Is Deleted", HttpStatus.OK);
    }


}
