package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.Command;

import java.util.Set;
import java.util.UUID;

public class EmptyCart implements Command {
    CartService cart;

    public EmptyCart(CartService cart) {
        this.cart = cart;
    }
    public void execute(UUID id) {
        cart.emptyCart(id);
    }

    public void execute(UUID userID, String itemID) {

    }

    public Set<String> executeGet() {
        return null;
    }
}
