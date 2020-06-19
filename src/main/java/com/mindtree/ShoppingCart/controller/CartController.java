package com.mindtree.ShoppingCart.controller;


import com.mindtree.ShoppingCart.dto.CartDto;
import com.mindtree.ShoppingCart.exception.ApplicationException;
import com.mindtree.ShoppingCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;


    @RequestMapping(
            value = "cart/getCart/{userId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CartDto> getCartByUserId(@PathVariable int userId) throws ApplicationException {
        return new ResponseEntity<CartDto>(cartService.getCart(userId), HttpStatus.OK);
    }



    @RequestMapping(
            value = "cart/addCart/{userId}/{productId}/{noOfProduct}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CartDto> addCartToUser(@PathVariable int userId, @PathVariable int productId, @PathVariable int noOfProduct) throws ApplicationException {
        return new ResponseEntity<CartDto>(cartService.addCart(userId, productId, noOfProduct), HttpStatus.OK);
    }



    @RequestMapping(
            value = "cart/addCart/{userId}/{productId}/{noOfProduct}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CartDto> updateCart(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity) throws ApplicationException {
        return new ResponseEntity<CartDto>(cartService.updateProduct(userId, productId, quantity), HttpStatus.OK);
    }



    @RequestMapping(
            value = "cat/remove-one-product",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<String> removeOneProduct(@RequestParam int userId, @RequestParam int productId) throws ApplicationException {
        return ResponseEntity.ok().body(cartService.removeOneProduct(userId, productId));
    }



    @RequestMapping(
            value = "cart/remove-all-product",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<String> removeAllProduct(@RequestParam int userId) throws ApplicationException {
        return ResponseEntity.ok().body(cartService.removeAllProduct(userId));
    }
}
