package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.Command;

import java.util.Set;
import java.util.UUID;

public class AddItem implements Command {
    CartService cart;

    public AddItem(CartService cart) {
        this.cart = cart;
    }
    public void execute(UUID uuid) {

    }

    public void execute(UUID userID, String itemID) {
        cart.addItemToCart(userID, itemID);
    }

    public Set<String> executeGet() {
        return null;
    }
}
