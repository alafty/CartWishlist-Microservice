package com.RAAF.CartWishlist.Cart;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;


@Table("user_carts")
public class Cart {
    @PrimaryKey
    private UUID userID;
    private Set<String> cartItems;

    private Set<Double> cartItemsPrices;

    public Cart(UUID userID, Set<String> cartItems) {
        this.userID = userID;
        this.cartItems = cartItems;
    }

    public UUID getUserID() {
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
