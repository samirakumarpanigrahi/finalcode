package com.mindtree.ShoppingCart.service.serviceImpl;


import com.mindtree.ShoppingCart.dao.UserDao;
import com.mindtree.ShoppingCart.dto.UserDto;
import com.mindtree.ShoppingCart.entity.UserEntity;
import com.mindtree.ShoppingCart.exception.ServiceException;
import com.mindtree.ShoppingCart.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    private ModelMapper mapper=new ModelMapper();

    @Override
    public UserDto addCustomer(UserDto user) {
       UserEntity userEntity=userDao.addCustomer(dtoToEntity(user));
       return entityToDto(userEntity);
    }

    @Override
    public UserDto getCustomerById(int id) throws ServiceException {
        UserEntity userEntity=userDao.getCustomerById(id);

        return entityToDto(userEntity);
    }



    @Override
    public List<UserDto> getAllCustomer() {
       List<UserEntity> userList=userDao.getAllUser();
       List<UserDto> resultUserList=userList.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
       return resultUserList;
    }

    private UserEntity dtoToEntity(UserDto user)
    {
        return mapper.map(user,UserEntity.class);
    }

    private UserDto entityToDto(UserEntity userEntity) {

        return mapper.map(userEntity,UserDto.class);
    }
}
