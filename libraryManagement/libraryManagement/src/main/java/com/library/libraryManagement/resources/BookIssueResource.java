package com.library.libraryManagement.resources;

import com.library.libraryManagement.models.BookIssueModel;
import com.library.libraryManagement.services.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xyz")
public class BookIssueResource {
    @Autowired
    BookIssueService bookIssueService;
    @PostMapping("/saveIssueDetails")
    public ResponseEntity saveIssueDetails(@RequestBody BookIssueModel bookIssueModel){
        return bookIssueService.saveIssueDetails(bookIssueModel);
    }

    @GetMapping("/getAllBookIssueDetails")
    public List<BookIssueModel> getAllBookIssueDetails(){
       return bookIssueService.getAllBookIssueDetails();
    }

    @PostMapping("/deleteBookIssueById/{bookIssueId}")
    public ResponseEntity deleteBookIssueById(@PathVariable("bookIssueId") Long bookIssueId){
        return bookIssueService.deleteBookIssueById(bookIssueId);
    }
}
