package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.Command;

import java.util.Set;
import java.util.UUID;

public class DeleteItem implements Command {
    CartService cart;

    public DeleteItem(CartService cart) {
        this.cart = cart;
    }
    public void execute(UUID uuid) {

    }

    public void execute(UUID userID, String itemID) {
        cart.deleteItem(userID, itemID);
    }

    public Set<String> executeGet() {
        return null;
    }
}
