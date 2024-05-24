package com.RAAF.CartWishlist.Wishlist.Commands;

import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.WishlistService;

import java.util.Set;

public class AddUser implements Command {
    WishlistService wishlist;

    public AddUser(WishlistService wishlist) {
        this.wishlist = wishlist;
    }
    public void execute(String id) {
        wishlist.addUser(id);
    }
    public Set<String> executeGet() {
        return null;
    }
}
