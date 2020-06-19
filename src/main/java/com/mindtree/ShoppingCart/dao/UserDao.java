package com.mindtree.ShoppingCart.dao;

import com.mindtree.ShoppingCart.entity.UserEntity;
import com.mindtree.ShoppingCart.exception.DaoException;

import java.util.List;

public interface UserDao {
    UserEntity addCustomer(UserEntity dtoToEntity);

    UserEntity getCustomerById(int id) throws DaoException;

    List<UserEntity> getAllUser();
}
