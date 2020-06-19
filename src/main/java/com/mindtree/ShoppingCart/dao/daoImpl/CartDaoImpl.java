package com.mindtree.ShoppingCart.dao.daoImpl;

import com.mindtree.ShoppingCart.dao.CartDao;
import com.mindtree.ShoppingCart.entity.CartEntity;
import com.mindtree.ShoppingCart.entity.ProductEntity;
import com.mindtree.ShoppingCart.entity.UserEntity;
import com.mindtree.ShoppingCart.exception.DaoException;
import com.mindtree.ShoppingCart.exception.ProductNotFoundException;
import com.mindtree.ShoppingCart.exception.UserNotFindException;
import com.mindtree.ShoppingCart.repository.CartRepository;
import com.mindtree.ShoppingCart.repository.ProductRepository;
import com.mindtree.ShoppingCart.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartDaoImpl implements CartDao {

    Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public CartEntity getCart(int userId) throws DaoException {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserNotFindException("This User Not Available,Please Check again"));
        if (user.getCartEntity() == null) {
            throw new ProductNotFoundException("Your Cart Is Empty,Please Add Some Product To Your Cart");
        }
        return user.getCartEntity();
    }


    @Override
    public CartEntity addCart(int userId, int productId, int noOfProduct) throws DaoException {

        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserNotFindException("This User Not Available,Please Check again"));
        ProductEntity product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("This Product Not Available,Please Check again"));
        CartEntity cart = new CartEntity();


        if (user.getCartEntity() == null && product.getCart() == null) {
            cart.setCartQuantity(noOfProduct);
            cart.setCartPrice(cart.getCartPrice() + product.getProductPrice() * noOfProduct);
            List<ProductEntity> productEntityList = new ArrayList<>();
            product.setProductQuantity(noOfProduct);
            product.setCart(cart);
            productEntityList.add(product);
            cart.setProductEntityList(productEntityList);
            cartRepository.saveAndFlush(cart);


            user.setCartEntity(cart);
            UserEntity result = userRepository.saveAndFlush(user);
            return result.getCartEntity();

        } else if (user.getCartEntity() != null && product.getCart() == null) {


            user.getCartEntity().setCartQuantity(user.getCartEntity().getCartQuantity() + noOfProduct);
            product.setCart(user.getCartEntity());
            product.setProductQuantity(noOfProduct);
            user.getCartEntity().getProductEntityList().add(product);
            user.getCartEntity().setCartPrice(user.getCartEntity().getCartPrice() + product.getProductPrice() * noOfProduct);


            UserEntity result = userRepository.saveAndFlush(user);
            return result.getCartEntity();


        } else if ((user.getCartEntity() != null) && (user.getCartEntity().getCartId() == product.getCart().getCartId())) {

            product.setProductQuantity(product.getProductQuantity() + noOfProduct);
            productRepository.save(product);

            user.getCartEntity().setCartQuantity(user.getCartEntity().getCartQuantity() + noOfProduct);
            user.getCartEntity().setCartPrice(user.getCartEntity().getCartPrice() + product.getProductPrice() * noOfProduct);

            UserEntity result = userRepository.saveAndFlush(user);
            return result.getCartEntity();
        } else if (user.getCartEntity() == null && product.getCart() != null) {
            throw new ProductNotFoundException("This product is already booked By Other Customer");
        }

        return null;
    }

    @Override
    public CartEntity updateProduct(int userId, int productId, int quantity) throws DaoException {


        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserNotFindException("This User Not Available,Please Check again"));
        ProductEntity product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("This Product Not Available,Please Check again"));


        user.getCartEntity().setCartQuantity(user.getCartEntity().getCartQuantity() - product.getProductQuantity() + quantity);
        user.getCartEntity().setCartPrice(user.getCartEntity().getCartPrice() - product.getProductPrice() * product.getProductQuantity() + product.getProductPrice() * quantity);
        product.setProductQuantity(quantity);
        productRepository.save(product);


        UserEntity result = userRepository.saveAndFlush(user);
        return result.getCartEntity();

    }

    @Override
    public CartEntity removeOneProduct(int userId, int productId) throws DaoException {

        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserNotFindException("This User Not Available,Please Check again"));
        ProductEntity product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("This Product Not Available,Please Check again"));
        if(user.getCartEntity()==null)
        {
            throw new DaoException("Empty Cart");
        }

        if(product.getCart()==null)
        {
            throw new ProductNotFoundException("You dont have this product in your cart");
        }


        if(product.getCart().getCartId()!= user.getCartEntity().getCartId())
        {

            throw new ProductNotFoundException("You dont have this product in your cart");
        }
        user.getCartEntity().getProductEntityList().remove(product);
        user.getCartEntity().setCartQuantity(user.getCartEntity().getCartQuantity() - product.getProductQuantity());
        user.getCartEntity().setCartPrice(user.getCartEntity().getCartPrice() - product.getProductPrice() * product.getProductQuantity());

        product.setProductQuantity(0);
        product.setCart(null);
        productRepository.save(product);

        UserEntity result = userRepository.saveAndFlush(user);
        return result.getCartEntity();


    }

    @Override
    public UserEntity removeAllProduct(int userId) throws DaoException {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserNotFindException("This User Not Available,Please Check again"));
if(user.getCartEntity()==null)
{
    throw new DaoException("Empty Cart");
}
        List<ProductEntity> productEntityList = user.getCartEntity().getProductEntityList();
        productEntityList.forEach(a -> a.setCart(null));


        user.getCartEntity().setCartPrice(0);
        user.getCartEntity().setCartQuantity(0);

        user.setCartEntity(null);

        UserEntity result = userRepository.saveAndFlush(user);
        return result;

    }
}
