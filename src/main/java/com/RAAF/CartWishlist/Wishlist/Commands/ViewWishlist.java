package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.WishlistService;

import java.util.Set;
import java.util.UUID;

public class ViewWishlist implements Command {
    WishlistService wishlist;
    public ViewWishlist(WishlistService wishlist) {
        this.wishlist = wishlist;
    }
    public Set<String> executeGet() {
        return wishlist.viewWishlist();
    }

    public void execute(UUID uuid) {

    }

    @Override
    public void execute(UUID userID, String itemID) {

    }
}
