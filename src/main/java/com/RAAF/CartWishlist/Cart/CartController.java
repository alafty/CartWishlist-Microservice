package com.RAAF.CartWishlist.Cart;

import com.RAAF.CartWishlist.Cart.Commands.*;
import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.dto.Item;
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

    //DONE
    @GetMapping()
    public Set<String> viewCart() {
        ViewCart viewCart = new ViewCart(this.cartService);
        return viewCart.executeGet(CartWishlistMicroserviceApplication.activeUserID);
    }

    @GetMapping("amount/")
    public double amountCart() {
        GetTotalCart  totalCart = new GetTotalCart(cartService);
        return totalCart.executeGet(CartWishlistMicroserviceApplication.activeUserID);
    }

    //DONE
    @PutMapping()
    public void addItemToCart(@RequestBody Item itemID) {
        AddItem addItem = new AddItem(cartService);
        addItem.execute(itemID.id);
    }

    //DONE
    @DeleteMapping()
    public void deleteItem(@RequestBody Item itemID) {
        DeleteItem deleteItem = new DeleteItem(cartService);
        deleteItem.execute(itemID.id);
    }


    @DeleteMapping("empty/")
    public void emptyCart() {
        EmptyCart emptyCart = new EmptyCart(cartService);
        emptyCart.execute(CartWishlistMicroserviceApplication.activeUserID);
    }

}
