package com.mindtree.ShoppingCart.dao.daoImpl;

import com.mindtree.ShoppingCart.dao.UserDao;
import com.mindtree.ShoppingCart.entity.UserEntity;
import com.mindtree.ShoppingCart.exception.DaoException;
import com.mindtree.ShoppingCart.exception.UserNotFindException;
import com.mindtree.ShoppingCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity addCustomer(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity getCustomerById(int id) throws DaoException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFindException("This User Not Available,Please Check again"));
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }
}
