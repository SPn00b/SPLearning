package org.example.designpatterns.creational;

import java.time.Year;

public class BookWithoutBuilderDesignPattern {

    private String isbn;
    private String title;
    private String genre;
    private String author;
    private Year published;
    private String description;

    public BookWithoutBuilderDesignPattern() {

    }

    public BookWithoutBuilderDesignPattern(String isbn, String title, String genre, String author, Year published, String description) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.published = published;
        this.description = description;
    }

    public BookWithoutBuilderDesignPattern createObject(String isbn, String title, String genre, String author, Year published, String description) throws Exception {
        if (true) {
            throw new Exception("Book has issues with object");
        }
        return new BookWithoutBuilderDesignPattern(isbn, title, genre, author, published, description);
    }

    public String getIsbn() {
        return isbn;

    }
    public String getTitle() {

        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public Year getPublished() {
        return published;
    }

    public String getDescription() {
        return description;
    }



}
