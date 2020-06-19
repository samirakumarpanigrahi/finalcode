package com.mindtree.ShoppingCart.service.serviceImpl;


import com.mindtree.ShoppingCart.dao.ProductDao;
import com.mindtree.ShoppingCart.dto.ProductDto;
import com.mindtree.ShoppingCart.entity.ApparalEntity;
import com.mindtree.ShoppingCart.entity.BookEntity;
import com.mindtree.ShoppingCart.entity.ProductEntity;
import com.mindtree.ShoppingCart.exception.NoSuchTypeException;
import com.mindtree.ShoppingCart.exception.ServiceException;
import com.mindtree.ShoppingCart.repository.ApparalRepository;
import com.mindtree.ShoppingCart.repository.BookRepository;
import com.mindtree.ShoppingCart.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductDao productDao;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ApparalRepository apparalRepository;
    private ModelMapper mapper = new ModelMapper();



    @Override
    public List<ProductDto> getByCategory(String type) throws ServiceException {

        if (type.equalsIgnoreCase("BOOK") || type.equalsIgnoreCase("BOOKS")) {
            List<BookEntity> bookEntities = productDao.getAllBook();
            List<ProductDto> productDtoList = bookEntities.stream().map(x -> convertEntityToDto(x)).collect(Collectors.toList());
            return productDtoList;
        } else if (type.equalsIgnoreCase("Apparal") || type.equalsIgnoreCase("Apparals")) {
            List<ApparalEntity> apparalEntities = productDao.getAllApparal();
            List<ProductDto> productDtoList = apparalEntities.stream().map(x -> convertEntityToDto(x)).collect(Collectors.toList());
            return productDtoList;
        }

        else {
            throw new NoSuchTypeException("This Type Product Not Available,Please Check again");
        }

    }


    @Override
    public ProductDto getById(int id) throws ServiceException {
        ProductEntity result = productDao.getById(id);
        return convertEntityToDto(result);
    }

    @Override
    public ProductDto getByname(String name) throws ServiceException {
        ProductEntity result = productDao.getByName(name);
        return convertEntityToDto(result);
    }


    private ProductDto convertEntityToDto(ProductEntity result) {
        return mapper.map(result, ProductDto.class);
    }

}
