package com.RAAF.CartWishlist.Cart.Commands;

import com.RAAF.CartWishlist.Cart.CartService;
import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import com.RAAF.CartWishlist.Command;

import java.util.Set;

public class AddItem implements Command {
    CartService cart;

    public AddItem(CartService cart) {
        this.cart = cart;
    }

    public void execute(String itemID) {
        cart.addItemToCart(CartWishlistMicroserviceApplication.activeUserID, itemID);
    }

    public Set<String> executeGet() {
        return null;
    }
}
