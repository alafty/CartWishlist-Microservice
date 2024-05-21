package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.Cart;
import com.RAAF.CartWishlist.Command;

public class EmptyCart implements Command {
    Cart cart;

    public EmptyCart(Cart cart) {
        this.cart = cart;
    }
    public void execute() {

    }
}
