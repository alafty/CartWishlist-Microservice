package com.RAAF.CartWishlist.Wishlist;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.UUID;

@Table
public class Wishlist {
    @PrimaryKey
    UUID userID;
    String[] wishlistItems;

    public Wishlist(UUID userID, String[] wishlistItems) {
        this.userID = userID;
        this.wishlistItems = wishlistItems;
    }

    public String toString() {
        return "user ID:" + userID + "/n" +
                "WishList:" + wishlistItems;
    }
}
