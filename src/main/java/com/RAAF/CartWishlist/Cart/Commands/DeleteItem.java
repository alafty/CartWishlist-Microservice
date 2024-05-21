package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.Cart;
import com.RAAF.CartWishlist.Command;

public class DeleteItem implements Command {
    Cart cart;

    public DeleteItem(Cart cart) {
        this.cart = cart;
    }
    public void execute() {

    }
}
