package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.Command;

import java.util.Set;

public class GetTotalCart implements Command {
    CartService cart;
    public GetTotalCart(CartService cart) {
        this.cart = cart;
    }
    public void execute(String uuid) {

    }

    public void execute(String userID, String itemID) {

    }

    public Set<String> executeGet() {
        return null;
    }

    public double executeGet(String id) {
        return cart.getTotalCartAmount(id);
    }
}
