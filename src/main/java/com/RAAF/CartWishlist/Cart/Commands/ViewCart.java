package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.Cart;
import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.Command;

import java.util.Set;

public class ViewCart implements Command {
    CartService cart;
    public ViewCart(CartService cart) {
        this.cart = cart;
    }
    public void execute(String userID, String itemID) {

    }

    @Override
    public Set<String> executeGet() {
        return null;
    }

    public Set<String> executeGet(String userID) {
        return cart.viewCart(userID);
    }
    @Override
    public void execute(String uuid) {

    }
}
