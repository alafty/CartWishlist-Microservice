package com.RAAF.CartWishlist.Cart;

import com.RAAF.CartWishlist.Wishlist.Wishlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CartRepository extends CrudRepository<Cart, UUID> {
    Cart findByUserID(UUID userID);

}
