package com.RAAF.CartWishlist.Wishlist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, String> {
    Wishlist findByUserID(String userID);
}
