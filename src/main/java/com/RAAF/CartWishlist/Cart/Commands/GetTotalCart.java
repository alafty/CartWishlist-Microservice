package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.Cart;
import com.RAAF.CartWishlist.Command;

public class GetTotalCart implements Command {
    Cart cart;
    public GetTotalCart(Cart cart) {
        this.cart = cart;
    }
    public void execute() {

    }
}
