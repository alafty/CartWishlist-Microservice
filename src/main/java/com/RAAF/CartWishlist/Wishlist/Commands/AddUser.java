package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.WishlistService;

import java.util.Set;
import java.util.UUID;

public class AddUser implements Command {
    WishlistService wishlist;

    public AddUser(WishlistService wishlist) {
        this.wishlist = wishlist;
    }
    public void execute(UUID uuid) {
        //TODO: Make sure to actually send the UUID when integrating
        wishlist.addUser(UUID.randomUUID());
    }

    @Override
    public void execute(UUID userID, String itemID) {

    }

    public Set<String> executeGet() {
        return null;
    }
}
