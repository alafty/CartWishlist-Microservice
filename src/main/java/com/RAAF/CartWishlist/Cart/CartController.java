package com.RAAF.CartWishlist.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "cart/v1/")
@Component
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Set<String> viewCart() {
        return cartService.viewCart();
    }

    @PostMapping
    public void addUser(@RequestBody String newUserID) {
        //TODO: Make sure to actually send the UUID when integrating
        System.out.println(newUserID);
        cartService.addUser(UUID.randomUUID());
    }

    @PutMapping
    public void addItemToCart(@RequestBody String userID, String itemID) {
        //TODO: Make sure to actually send the UUID when integrating
        System.out.println(itemID);
        cartService.addItemToCart(UUID.fromString(userID), itemID);
    }

    @DeleteMapping
    public void deleteItem(@RequestBody String userID, String itemID) {
        //TODO: Make sure to actually send the UUID and actual String when integrating
        cartService.deleteItem(UUID.fromString(userID), itemID);
    }
}
