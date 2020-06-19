package com.mindtree.ShoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ProductDto {

    private int productId;
    private String productName;
    private float productPrice;
    private int productQuantity;
    @JsonIgnoreProperties("productEntityList")
    private CartDto cart;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String genre;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String author;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String publication;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String brand;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String design;

    public ProductDto() {

    }

    public ProductDto(int productId, String productName, float productPrice, int productQuantity, CartDto cart, String genre, String author, String publication, String type, String brand, String design) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.cart = cart;
        this.genre = genre;
        this.author = author;
        this.publication = publication;
        this.type = type;
        this.brand = brand;
        this.design = design;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
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

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }
}
