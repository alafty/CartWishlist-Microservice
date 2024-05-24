package com.RAAF.CartWishlist.Wishlist;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;

@Table
public class Wishlist {
    @PrimaryKey
    String userID;
    Set<String> wishlistItems;

    public Wishlist(String userID, Set<String> wishlistItems) {
        this.userID = userID;
        this.wishlistItems = wishlistItems;
    }

    public String toString() {
        return "user ID:" + userID + "/n" +
                "WishList:" + wishlistItems;
    }

    public String getUserID() {
        return userID;
    }
    public Set<String> getWishlistItems() {
        return wishlistItems;
    }
}
