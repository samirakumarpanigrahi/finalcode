package com.mindtree.ShoppingCart.dao.daoImpl;


import com.mindtree.ShoppingCart.dao.ProductDao;
import com.mindtree.ShoppingCart.entity.ApparalEntity;
import com.mindtree.ShoppingCart.entity.BookEntity;
import com.mindtree.ShoppingCart.entity.ProductEntity;
import com.mindtree.ShoppingCart.exception.DaoException;
import com.mindtree.ShoppingCart.exception.NoApparalAvailabeException;
import com.mindtree.ShoppingCart.exception.NoBooksAvailableException;
import com.mindtree.ShoppingCart.exception.ProductNotFoundException;
import com.mindtree.ShoppingCart.repository.ApparalRepository;
import com.mindtree.ShoppingCart.repository.BookRepository;
import com.mindtree.ShoppingCart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    ProductRepository productRepository;


    @Autowired
    BookRepository bookRepository;


    @Autowired
    ApparalRepository apparalRepository;


    @Override
    public ProductEntity getById(int id) throws DaoException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("This Product Not Available,Please Check again"));
    }

    @Override
    public ProductEntity getByName(String name) throws DaoException {
        return productRepository.findByProductName(name).orElseThrow(() -> new ProductNotFoundException("This Product Not Available,Please Check again"));
    }

    @Override
    public List<ApparalEntity> getAllApparal() throws DaoException {
        if (apparalRepository.findAll().isEmpty()) {
            throw new NoApparalAvailabeException("This Type Product Not Available,Please Check again");
        }
        return apparalRepository.findAll();
    }

    @Override
    public List<BookEntity> getAllBook() throws DaoException {
        if (bookRepository.findAll().isEmpty()) {
            throw new NoBooksAvailableException("This Type Product Not Available,Please Check again");
        }
        return bookRepository.findAll();
    }
}
