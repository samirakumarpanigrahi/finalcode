package com.mindtree.ShoppingCart.service;

import com.mindtree.ShoppingCart.dto.UserDto;
import com.mindtree.ShoppingCart.entity.UserEntity;
import com.mindtree.ShoppingCart.exception.DaoException;
import com.mindtree.ShoppingCart.exception.ServiceException;
import com.mindtree.ShoppingCart.exception.UserNotFindException;

import java.util.List;

public interface UserService {

    UserDto addCustomer(UserDto user);

    UserDto getCustomerById(int id) throws DaoException, ServiceException;

    List<UserDto> getAllCustomer();
}
