package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.WishlistService;

import java.util.Set;
import java.util.UUID;

public class AddItem implements Command {
    WishlistService wishlist;

    public AddItem(WishlistService wishlist) {
        this.wishlist = wishlist;
    }


    public void execute(UUID uuid) {

    }

    @Override
    public void execute(UUID userID, String itemID) {
        wishlist.addItemToWishlist(userID, itemID);
    }

    @Override
    public Set<String> executeGet() {
        return null;
    }
}