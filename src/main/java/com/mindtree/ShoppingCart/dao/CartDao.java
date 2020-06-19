package com.mindtree.ShoppingCart.dao;

import com.mindtree.ShoppingCart.entity.CartEntity;
import com.mindtree.ShoppingCart.entity.UserEntity;
import com.mindtree.ShoppingCart.exception.DaoException;
import com.mindtree.ShoppingCart.exception.UserNotFindException;

public interface CartDao {
    CartEntity getCart(int userId) throws DaoException;

    CartEntity addCart(int userId, int productId, int noOfProduct) throws DaoException;

    CartEntity updateProduct(int userId, int productId, int quantity) throws UserNotFindException, DaoException;

    CartEntity removeOneProduct(int userId, int productId) throws DaoException;

    UserEntity removeAllProduct(int userId) throws DaoException;
}
