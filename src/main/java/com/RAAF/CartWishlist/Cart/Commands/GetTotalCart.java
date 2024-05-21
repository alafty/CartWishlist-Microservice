package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.Command;

import java.util.Set;
import java.util.UUID;

public class GetTotalCart implements Command {
    CartService cart;
    public GetTotalCart(CartService cart) {
        this.cart = cart;
    }
    public void execute(UUID uuid) {

    }

    public void execute(UUID userID, String itemID) {

    }

    public Set<String> executeGet() {
        return null;
    }

    public double executeGet(UUID id) {
        return cart.getTotalCartAmount(id);
    }
}
