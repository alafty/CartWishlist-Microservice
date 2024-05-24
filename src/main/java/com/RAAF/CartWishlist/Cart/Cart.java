package com.RAAF.CartWishlist.Cart;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Table
public class Cart {
    @PrimaryKey
    private String userID;
    private HashSet<String> cartItems;

    private Set<Double> cartItemsPrices;

    public Cart(String userID, HashSet<String> cartItems) {
        this.userID = userID;
        this.cartItems = cartItems;
    }

    public String getUserID() {
        return userID;
    }

    public Set<String> getCartItems() {
        return cartItems;
    }

    public Set<Double> getCartItemsPrices() {
        return cartItemsPrices;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userID=" + userID +
                ", cartItems=" + cartItems +
                '}';
    }
}
