package com.RAAF.CartWishlist.Cart;

import com.RAAF.CartWishlist.Cart.Commands.*;
import com.RAAF.CartWishlist.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;

import javax.swing.text.View;
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

    @GetMapping("view/")
    public Set<String> viewCart(@RequestBody String userID) {
        ViewCart viewCart = new ViewCart(this.cartService);
        return viewCart.executeGet(CartWishlistMicroserviceApplication.tempUser.get(0));
    }
    @GetMapping("amount/")
    public double amountCart(@RequestBody String userID) {
        GetTotalCart  totalCart = new GetTotalCart(cartService);
        return totalCart.executeGet(CartWishlistMicroserviceApplication.tempUser.get(0));
    }


    @PutMapping("add/")
    public void addItemToCart(@RequestBody String userID, String itemID) {
        AddItem addItem = new AddItem(cartService);
        addItem.execute(CartWishlistMicroserviceApplication.tempUser.get(0), itemID);
    }

    @DeleteMapping("delete/")
    public void deleteItem(@RequestBody String userID, String itemID) {
        DeleteItem deleteItem = new DeleteItem(cartService);
        deleteItem.execute(CartWishlistMicroserviceApplication.tempUser.get(0), itemID);
    }

    @DeleteMapping("empty/")
    public void emptyCart(@RequestBody String userID) {
        EmptyCart emptyCart = new EmptyCart(cartService);
        emptyCart.execute(CartWishlistMicroserviceApplication.tempUser.get(0));
    }

}
