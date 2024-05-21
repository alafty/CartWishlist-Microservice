package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.Wishlist;

public class DeleteItem implements Command {
    Wishlist wishlist;

    public DeleteItem(Wishlist wishlist)
    {
        this.wishlist = wishlist;
    }
    public void execute() {

    }
}
