package com.RAAF.CartWishlist.Wishlist;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Table
public class Wishlist {
    @PrimaryKey
    UUID userID;
    Set<String> wishlistItems;

    public Wishlist(UUID userID, Set<String> wishlistItems) {
        this.userID = userID;
        this.wishlistItems = wishlistItems;
    }

    public String toString() {
        return "user ID:" + userID + "/n" +
                "WishList:" + wishlistItems;
    }

    public UUID getUserID() {
        return userID;
    }
    public Set<String> getWishlistItems() {
        return wishlistItems;
    }
}
