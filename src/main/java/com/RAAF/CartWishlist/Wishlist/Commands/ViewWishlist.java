package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.WishlistService;

import java.util.Set;

public class ViewWishlist implements Command {
    WishlistService wishlist;
    public ViewWishlist(WishlistService wishlist) {
        this.wishlist = wishlist;
    }
    public Set<String> executeGet() {
        return wishlist.viewWishlist(CartWishlistMicroserviceApplication.activeUserID);
    }

    public void execute(String uuid) {

    }
}
