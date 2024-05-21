package com.RAAF.CartWishlist.Wishlist;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

//Receiver
@Service
public class WishlistService {
    public final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }
    public Set<String> viewWishlist() {
        //TODO: Fetch current user ID from other microservice
        UUID currentUser = CartWishlistMicroserviceApplication.getTempUser().get(0);
        Wishlist currentWishlist = wishlistRepository.findById(currentUser)
                                        .orElse(null);
        return currentWishlist.getWishlistItems();
    }

    public void addUser(UUID newUserID) {
        Wishlist newUserWishlist = new Wishlist(newUserID, new HashSet<>(List.of("")));
        wishlistRepository.save(newUserWishlist);
    }

    public void deleteItem(UUID userID, String itemToBeDeleted) {
        Wishlist currentUserWishlist = wishlistRepository.findById(userID)
                                            .orElse(null);
        currentUserWishlist.getWishlistItems().remove(itemToBeDeleted);
        wishlistRepository.save(currentUserWishlist);
    }

    public void addItemToWishlist(UUID userID, String itemToBeAdded) {
        Wishlist currentUserWishlist = wishlistRepository.findById(userID)
                .orElse(null);
        currentUserWishlist.getWishlistItems().add(itemToBeAdded);
        wishlistRepository.save(currentUserWishlist);

    }
}
