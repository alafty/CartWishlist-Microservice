package com.RAAF.CartWishlist.Wishlist;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import org.springframework.stereotype.Service;

import java.util.*;

//Receiver
@Service
public class WishlistService {
    public final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Set<String> viewWishlist(String currentUser) {
        //TODO: Fetch current user ID from other microservice
        Wishlist currentWishlist = wishlistRepository.findById(currentUser)
                                        .orElse(null);
        if(currentWishlist == null) {
            addUser(currentUser);
            currentWishlist = wishlistRepository.findById(currentUser)
                    .orElse(null);
        }
        return currentWishlist.getWishlistItems();
    }

    public void addUser(String newUserID) {
        Wishlist newUserWishlist = new Wishlist(newUserID, new HashSet<>(List.of("")));
        wishlistRepository.save(newUserWishlist);
    }

    public void deleteItem(String userID, String itemToBeDeleted) {
        Wishlist currentUserWishlist = wishlistRepository.findById(userID)
                                            .orElse(null);
        if(currentUserWishlist == null) {
            addUser(userID);
            currentUserWishlist = wishlistRepository.findByUserID(userID);
        }
        currentUserWishlist.getWishlistItems().remove(itemToBeDeleted);
        wishlistRepository.save(currentUserWishlist);
    }

    public void addItemToWishlist(String userID, String itemToBeAdded) {
        Wishlist currentUserWishlist = wishlistRepository.findById(userID)
                .orElse(null);
        if(currentUserWishlist == null) {
            addUser(userID);
            currentUserWishlist = wishlistRepository.findByUserID(userID);
        }
        currentUserWishlist.getWishlistItems().add(itemToBeAdded);
        wishlistRepository.save(currentUserWishlist);

    }
}
