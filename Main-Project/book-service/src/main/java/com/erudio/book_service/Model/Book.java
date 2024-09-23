package com.erudio.book_service.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author",nullable = false)
    private String author;
    @Column(name = "launch_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false,length = 250)
    private String title;
    @Transient
    private String currency;
    @Transient
    private String enviroment;

    public Book() {
    }

    public Book(Long id, String author, String title, Date launchDate, Double price, String currency, String enviroment) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
        this.currency = currency;
        this.enviroment = enviroment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(id, book.id) && Objects.equals(author, book.author) && Objects.equals(launchDate, book.launchDate) && Objects.equals(price, book.price) && Objects.equals(title, book.title) && Objects.equals(currency, book.currency) && Objects.equals(enviroment, book.enviroment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launchDate, price, title, currency, enviroment);
    }
}
