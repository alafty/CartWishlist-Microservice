package com.RAAF.CartWishlist.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "cart/")
@Component
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/view")
    public Set<String> viewCart(@RequestParam("userId") String userID) {
        return cartService.viewCart(UUID.fromString(userID));
    }
    @GetMapping("/amount")
    public double amountCart(@RequestParam("userId") String userID) {
        return cartService.getTotalCartAmount(UUID.fromString(userID));
    }


    @PutMapping("/add")
    public void addItemToCart(@RequestBody String userID, String itemID) {
        cartService.addItemToCart(UUID.fromString(userID), itemID);
    }

    @DeleteMapping("/delete")
    public void deleteItem(@RequestBody String userID, String itemID) {
        cartService.deleteItem(UUID.fromString(userID), itemID);
    }

    @DeleteMapping("/empty")
    public void emptyCart(@RequestBody String userID) {
        cartService.emptyCart(UUID.fromString(userID));
    }

}
