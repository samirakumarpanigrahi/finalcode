package com.mindtree.ShoppingCart.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class UserEntity implements Comparable<UserEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;

    @OneToOne(cascade= CascadeType.ALL)
    private CartEntity cartEntity;


    public UserEntity(int userId, String userName, CartEntity cartEntity) {
        this.userId = userId;
        this.userName = userName;
        this.cartEntity = cartEntity;
    }

    public UserEntity() {

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

    public CartEntity getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return getUserId() == that.getUserId() &&
                getUserName().equals(that.getUserName()) &&
                getCartEntity().equals(that.getCartEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName(), getCartEntity());
    }

    @Override
    public int compareTo(UserEntity user) {
        if(userId==user.getUserId())
        {
            return 0;
        }
        else if(userId>user.getUserId())
        {
            return 1;
        }
        else
            return -1;
    }
}
