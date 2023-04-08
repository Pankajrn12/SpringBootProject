package com.library.libraryManagement.repositories;

import com.library.libraryManagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
