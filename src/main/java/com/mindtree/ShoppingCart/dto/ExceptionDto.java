package com.mindtree.ShoppingCart.dto;

public class ExceptionDto {

    String message;
    String url;

    public ExceptionDto(String message, String url) {
        this.message = message;
        this.url = url;
    }

    public ExceptionDto() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
