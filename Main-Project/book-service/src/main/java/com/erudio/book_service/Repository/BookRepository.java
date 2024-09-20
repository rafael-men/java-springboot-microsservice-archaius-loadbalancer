package com.erudio.book_service.Repository;

import com.erudio.book_service.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
