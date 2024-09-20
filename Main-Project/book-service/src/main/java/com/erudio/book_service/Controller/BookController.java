package com.erudio.book_service.Controller;


import com.erudio.book_service.Model.Book;
import com.erudio.book_service.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @GetMapping(value = "/{id}/{currency}")
    public Book findById(@PathVariable("id")Long id,@PathVariable("currency") String currency) {
        var book = repository.getById(id);
        if(book == null) {
            throw new RuntimeException("Book not found...");
        }
        var port = environment.getProperty("local.server.port");
        book.setEnviroment(port);
        return book;
    }
}
