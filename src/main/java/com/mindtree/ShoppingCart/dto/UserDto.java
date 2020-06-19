package com.mindtree.ShoppingCart.dto;

public class UserDto {

    private int userId;
    private String userName;


    private CartDto cart;

    public UserDto(int userId, String userName, CartDto cart) {
        this.userId = userId;
        this.userName = userName;
        this.cart = cart;
    }

    public UserDto() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }
}
