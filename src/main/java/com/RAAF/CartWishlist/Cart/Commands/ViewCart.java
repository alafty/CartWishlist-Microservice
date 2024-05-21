package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.Cart;
import com.RAAF.CartWishlist.Command;

public class ViewCart implements Command {
    Cart cart;
    public ViewCart(Cart cart) {
        this.cart = cart;
    }
    public void execute() {

    }
}
