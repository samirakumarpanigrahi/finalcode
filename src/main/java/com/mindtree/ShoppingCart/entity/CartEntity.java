package com.mindtree.ShoppingCart.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
public class CartEntity implements Comparable<CartEntity>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;


    @Column(columnDefinition = "int default 0")
    private int cartQuantity;

    @Column(columnDefinition = "int default 0")
    private float cartPrice;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private List<ProductEntity>productEntityList;


    public CartEntity(int cartId, int cartQuantity, float cartPrice, List<ProductEntity> productEntityList) {
        this.cartId = cartId;
        this.cartQuantity = cartQuantity;
        this.cartPrice = cartPrice;
        this.productEntityList = productEntityList;
    }

    public CartEntity() {

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

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return cartId == that.cartId &&
                cartQuantity == that.cartQuantity &&
                Float.compare(that.cartPrice, cartPrice) == 0 &&
                productEntityList.equals(that.productEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, cartQuantity, cartPrice, productEntityList);
    }


    @Override
    public int compareTo(CartEntity cart) {
        if(cartPrice==cart.getCartPrice())
        {
            return 0;
        }
        else if(cartPrice>cart.getCartPrice())
        {
            return 1;
        }
        else
            return -1;
    }
}

