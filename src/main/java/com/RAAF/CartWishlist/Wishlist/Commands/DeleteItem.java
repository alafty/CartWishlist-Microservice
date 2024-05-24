package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
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
    public void execute(String itemID) {
        wishlist.deleteItem(CartWishlistMicroserviceApplication.activeUserID, itemID);
    }

    public Set<String> executeGet() {
        return null;
    }
}
