package com.erudio.book_service.Controller;


import com.erudio.book_service.Model.Book;
import com.erudio.book_service.Proxy.CambioProxy;
import com.erudio.book_service.Repository.BookRepository;
import com.erudio.book_service.Response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping(value = "/{id}/{currency}")
    public Book findById(@PathVariable("id")Long id,@PathVariable("currency") String currency) {
        var book = repository.getById(id);
        if(book == null) {
            throw new RuntimeException("Book not found...");
        }
       var cambio = proxy.getCambio(book.getPrice(),"USD",currency);
        var port = environment.getProperty("local.server.port");
        book.setEnviroment("Book Port: " + port + "Cambio Port" + cambio.getEnviroment());
        book.setPrice(cambio.getConvertedValue());
        return book;
    }
    //* @GetMapping(value = "/{id}/{currency}")
    //    public Book findById(@PathVariable("id")Long id,@PathVariable("currency") String currency) {
    //        var book = repository.getById(id);
    //        if(book == null) {
    //            throw new RuntimeException("Book not found...");
    //        }
    //        HashMap<String,String> params=new HashMap<>();
    //        params.put("amount",book.getPrice().toString());
    //        params.put("from","USD");
    //        params.put("to",currency);
    //
    //        var response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}", Cambio.class,params);
    //        var cambio = response.getBody();
    //        var port = environment.getProperty("local.server.port");
    //        book.setEnviroment(port);
    //        book.setPrice(cambio.getConvertedValue());
    //        return book;
    //    }
}
