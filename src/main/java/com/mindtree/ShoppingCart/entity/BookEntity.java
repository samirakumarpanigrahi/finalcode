package com.mindtree.ShoppingCart.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class BookEntity extends ProductEntity {


    private String genre;

    private  String author;

    private String publications;


    public BookEntity(String genre, String author, String publications) {
        super();
        this.genre = genre;
        this.author = author;
        this.publications = publications;
    }

    public BookEntity() {
        super();
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
        return publications;
    }

    public void setPublications(String publications) {
        this.publications = publications;
    }
}
