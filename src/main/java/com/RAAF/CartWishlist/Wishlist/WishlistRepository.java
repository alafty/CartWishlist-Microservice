package com.RAAF.CartWishlist.Wishlist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, UUID> {
    Wishlist findByUserID(UUID userID);
}
