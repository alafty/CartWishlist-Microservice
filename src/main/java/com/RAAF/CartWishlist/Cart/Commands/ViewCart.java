package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.Cart;
import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.Command;

import java.util.Set;
import java.util.UUID;

public class ViewCart implements Command {
    CartService cart;
    public ViewCart(CartService cart) {
        this.cart = cart;
    }
    public void execute(UUID userID, String itemID) {

    }

    @Override
    public Set<String> executeGet() {
        return null;
    }

    public Set<String> executeGet(UUID userID) {
        return cart.viewCart(userID);
    }
    @Override
    public void execute(UUID uuid) {

    }
}
