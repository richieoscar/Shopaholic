package com.richieoscar.shopaholic.controllers;

import com.richieoscar.shopaholic.dto.requests.ModifyCartRequest;
import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.entities.Cart;
import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.repositories.CartRepository;
import com.richieoscar.shopaholic.repositories.ItemRepository;
import com.richieoscar.shopaholic.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
@Slf4j
public class CartController {

    private CartRepository cartRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;


    @PostMapping("/addToCart")
    public ResponseEntity<Cart> addToCart(@RequestBody ModifyCartRequest request) {
        Optional<AppUser> optionalAppUser = userRepository.findByEmail(request.getUserEmail());
        if (!optionalAppUser.isPresent()) {
            log.error("User not found");
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
        Optional<Item> optionalItem = itemRepository.findById(request.getItemId());
        if (!optionalItem.isPresent()) {
            log.error("Item not found");
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
        AppUser user = optionalAppUser.get();
        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
        }
        cart.addItem(optionalItem.get());
        Cart savedCart = cartRepository.save(cart);
        user.setCart(savedCart);
        userRepository.save(user);
        log.info("Added Item to Cart");
        return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);
    }

    @PostMapping("/removeFromCart")
    public ResponseEntity<Cart> removeFromCart(@RequestBody ModifyCartRequest request) {
        Optional<AppUser> optionalUser = userRepository.findByEmail(request.getUserEmail());
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
        Optional<Item> optionalItem = itemRepository.findById(request.getItemId());
        if (!optionalItem.isPresent()) {
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
        AppUser user = optionalUser.get();
        Cart cart = user.getCart();
        cart.removeItem(optionalItem.get());
        Cart savedCart = cartRepository.save(cart);
        return ResponseEntity.ok(savedCart);
    }
}
