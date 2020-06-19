package com.mindtree.ShoppingCart.service.serviceImpl;


import com.mindtree.ShoppingCart.dao.CartDao;
import com.mindtree.ShoppingCart.dto.CartDto;
import com.mindtree.ShoppingCart.entity.CartEntity;
import com.mindtree.ShoppingCart.entity.UserEntity;
import com.mindtree.ShoppingCart.exception.ServiceException;
import com.mindtree.ShoppingCart.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CartServiceImpl implements CartService {


    @Autowired
    private CartDao cartDao;

    private ModelMapper mapper = new ModelMapper();


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String removeAllProduct(int userId) throws ServiceException {
        UserEntity result = cartDao.removeAllProduct(userId);
        if (result != null) {
            return "Removed Sucessfully";
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String removeOneProduct(int userId, int productId) throws ServiceException {
        CartEntity user = cartDao.removeOneProduct(userId, productId);
        if (user != null) {
            return "Removed Sucessfully";
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CartDto updateProduct(int userId, int productId, int quantity) throws ServiceException {
        CartEntity result = cartDao.updateProduct(userId, productId, quantity);
        return convertEntityToDto(result);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CartDto addCart(int userId, int productId, int noOfProduct) throws ServiceException {
        CartEntity result = cartDao.addCart(userId, productId, noOfProduct);
        return convertEntityToDto(result);
    }

    @Override
    public CartDto getCart(int userId) throws ServiceException {
        CartEntity result = cartDao.getCart(userId);
        return convertEntityToDto(result);
    }

    private CartDto convertEntityToDto(CartEntity result) {

        return mapper.map(result, CartDto.class);
    }
}
