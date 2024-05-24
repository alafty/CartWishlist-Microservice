package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.WishlistService;

import java.util.Set;

public class AddItem implements Command {
    WishlistService wishlist;

    public AddItem(WishlistService wishlist) {
        this.wishlist = wishlist;
    }

    @Override
    public void execute(String itemID) {
        wishlist.addItemToWishlist(CartWishlistMicroserviceApplication.activeUserID, itemID);
    }

    @Override
    public Set<String> executeGet() {
        return null;
    }
}
