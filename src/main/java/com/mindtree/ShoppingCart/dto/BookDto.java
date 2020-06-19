package com.mindtree.ShoppingCart.dto;

public class BookDto {

    private String genre;

    private  String author;

    private String publication;

    public BookDto(String genre, String author, String publications) {
        this.genre = genre;
        this.author = author;
        this.publication = publications;
    }

    public BookDto() {

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublications() {
        return publication;
    }

    public void setPublications(String publications) {
        this.publication= publications;
    }
}
