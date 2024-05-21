package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.Wishlist;

public class AddItem implements Command {
    Wishlist wishlist;

    public AddItem(Wishlist wishlist) {
        this.wishlist = wishlist;
    }


    public void execute() {

    }
}
