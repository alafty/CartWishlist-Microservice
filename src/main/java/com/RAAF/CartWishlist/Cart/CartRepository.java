package com.RAAF.CartWishlist.Cart;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CartRepository extends CrudRepository<Cart, UUID> {
    Cart findByUserID(UUID userID);
}
