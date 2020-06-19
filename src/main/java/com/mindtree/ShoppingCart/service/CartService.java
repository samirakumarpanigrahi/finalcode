package com.mindtree.ShoppingCart.service;

import com.mindtree.ShoppingCart.dto.CartDto;
import com.mindtree.ShoppingCart.entity.CartEntity;
import com.mindtree.ShoppingCart.exception.DaoException;
import com.mindtree.ShoppingCart.exception.ServiceException;

import java.util.List;

public interface CartService {




    String removeAllProduct(int userId) throws ServiceException;

    String removeOneProduct(int userId, int productId) throws ServiceException;

    CartDto updateProduct(int userId, int productId, int quantity) throws ServiceException;

    CartDto addCart(int userId, int productId, int noOfProduct) throws ServiceException;

    CartDto getCart(int userId) throws ServiceException;
}
