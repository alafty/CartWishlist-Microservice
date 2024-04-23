package com.RAAF.CartWishlist.Wishlist;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;
public interface WishlistRepository extends CrudRepository<Wishlist, UUID> {
    Wishlist findByUserID(UUID userID);
}
