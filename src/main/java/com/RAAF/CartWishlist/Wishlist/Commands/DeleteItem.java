package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.WishlistService;

import java.util.Set;
import java.util.UUID;

public class DeleteItem implements Command {
    WishlistService wishlist;
    public DeleteItem(WishlistService wishlist)
    {
        this.wishlist = wishlist;
    }
    public void execute(UUID userID, String itemID) {
        wishlist.deleteItem(userID, itemID);
    }
    public void execute(UUID uuid) {

    }
    public Set<String> executeGet() {
        return null;
    }
}
