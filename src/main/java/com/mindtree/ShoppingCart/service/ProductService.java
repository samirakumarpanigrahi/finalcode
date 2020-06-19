package com.mindtree.ShoppingCart.service;


import com.mindtree.ShoppingCart.dto.ApparalDto;
import com.mindtree.ShoppingCart.dto.BookDto;
import com.mindtree.ShoppingCart.dto.ProductDto;
import com.mindtree.ShoppingCart.entity.ApparalEntity;
import com.mindtree.ShoppingCart.entity.BookEntity;
import com.mindtree.ShoppingCart.entity.ProductEntity;
import com.mindtree.ShoppingCart.exception.DaoException;
import com.mindtree.ShoppingCart.exception.ServiceException;

import java.util.List;

public interface ProductService {

    List<ProductDto> getByCategory(String type) throws ServiceException;



    ProductDto getById(int id) throws DaoException, ServiceException;

    ProductDto getByname(String name) throws ServiceException;
}
