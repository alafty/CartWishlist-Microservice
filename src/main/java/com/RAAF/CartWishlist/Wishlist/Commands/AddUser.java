package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.Wishlist;

public class AddUser implements Command {
    Wishlist wishlist;

    public AddUser(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
    public void execute() {

    }
}
