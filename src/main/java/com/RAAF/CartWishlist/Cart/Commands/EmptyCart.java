package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.Command;

import java.util.Set;

public class EmptyCart implements Command {
    CartService cart;

    public EmptyCart(CartService cart) {
        this.cart = cart;
    }
    public void execute(String id) {
        cart.emptyCart(id);
    }

    public void execute(String userID, String itemID) {

    }

    public Set<String> executeGet() {
        return null;
    }
}
