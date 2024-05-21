package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.Cart;
import com.RAAF.CartWishlist.Command;

public class AddItem implements Command {
    Cart cart;

    public AddItem(Cart cart) {
        this.cart = cart;
    }
    public void execute() {

    }
}
