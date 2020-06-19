package com.mindtree.ShoppingCart.dao;

import com.mindtree.ShoppingCart.entity.ApparalEntity;
import com.mindtree.ShoppingCart.entity.BookEntity;
import com.mindtree.ShoppingCart.entity.ProductEntity;
import com.mindtree.ShoppingCart.exception.DaoException;
import com.mindtree.ShoppingCart.exception.NoApparalAvailabeException;
import com.mindtree.ShoppingCart.exception.ProductNotFoundException;

import java.util.List;

public interface ProductDao {
   

    ProductEntity getById(int id) throws DaoException;

    ProductEntity getByName(String name) throws DaoException;

    List<ApparalEntity> getAllApparal() throws  DaoException;

    List<BookEntity> getAllBook() throws DaoException;
}
