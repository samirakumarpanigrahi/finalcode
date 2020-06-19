package com.mindtree.ShoppingCart.controller;


import com.mindtree.ShoppingCart.dto.UserDto;
import com.mindtree.ShoppingCart.exception.ApplicationException;
import com.mindtree.ShoppingCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping(
            value = "user/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> addCustomer(@RequestBody UserDto user) {
        return ResponseEntity.ok().body(userService.addCustomer(user));
    }

    @RequestMapping(
            value = "user/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<UserDto> getCustomerById(@PathVariable int id) throws ApplicationException {
        return ResponseEntity.ok().body(userService.getCustomerById(id));
    }


    @RequestMapping(
            value = "user/getAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<UserDto>> getAllCustomer() {
        return ResponseEntity.ok().body(userService.getAllCustomer());
    }
}
