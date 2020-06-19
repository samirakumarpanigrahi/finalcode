package com.mindtree.ShoppingCart.controller;


import com.mindtree.ShoppingCart.dto.ApparalDto;
import com.mindtree.ShoppingCart.dto.BookDto;
import com.mindtree.ShoppingCart.dto.ProductDto;
import com.mindtree.ShoppingCart.entity.ApparalEntity;
import com.mindtree.ShoppingCart.entity.BookEntity;
import com.mindtree.ShoppingCart.entity.ProductEntity;
import com.mindtree.ShoppingCart.exception.ApplicationException;
import com.mindtree.ShoppingCart.exception.ServiceException;
import com.mindtree.ShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;


    @RequestMapping(
            value = "product/getById/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProductDto> getById(@PathVariable int id) throws ApplicationException
    {
        return ResponseEntity.ok().body(productService.getById(id));
    }


   @RequestMapping(
           value = "product/getByName/{name}",
           method = RequestMethod.GET,
           produces = MediaType.APPLICATION_JSON_VALUE
   )
    public ResponseEntity<ProductDto> getByName(@PathVariable String name) throws ApplicationException {
        return ResponseEntity.ok().body(productService.getByname(name));
    }


    @RequestMapping(
            value = "product/getByCategory/{type}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ProductDto> >getByCategory(@PathVariable String type) throws ApplicationException
    {
        return ResponseEntity.ok().body(productService.getByCategory(type));
    }





}
