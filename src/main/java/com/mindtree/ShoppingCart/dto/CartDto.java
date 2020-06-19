package com.mindtree.ShoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.ShoppingCart.entity.CartEntity;
import com.mindtree.ShoppingCart.entity.ProductEntity;


import java.util.List;

public class CartDto {

    private int cartId;
    private int cartQuantity;
    private float cartPrice;

    @JsonIgnoreProperties("cart")
    private List<ProductDto> productEntityList;

    public CartDto(int cartId, int cartQuantity, float cartPrice, List<ProductDto> productEntityList) {
        this.cartId = cartId;
        this.cartQuantity = cartQuantity;
        this.cartPrice = cartPrice;
        this.productEntityList = productEntityList;
    }

    public CartDto() {

    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public float getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(float cartPrice) {
        this.cartPrice = cartPrice;
    }

    public List<ProductDto> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductDto> productEntityList) {
        this.productEntityList = productEntityList;
    }


}
