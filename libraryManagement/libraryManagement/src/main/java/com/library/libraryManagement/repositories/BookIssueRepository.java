package com.library.libraryManagement.repositories;

import com.library.libraryManagement.entities.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {
}
