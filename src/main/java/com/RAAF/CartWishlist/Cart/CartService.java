package com.RAAF.CartWishlist.Cart;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Set<String> viewCart() {
        //TODO: Fetch current user ID from other microservice
        UUID currentUser = (UUID) CartWishlistMicroserviceApplication.getTempUser().get(0);
        Cart currentCart = cartRepository.findById(currentUser)
                .orElse(null);
        return currentCart.getCartItems();
    }

    public void addUser(UUID newUserID) {
        Cart newUserCart = new Cart(newUserID, new HashSet<>(List.of("")));
        cartRepository.save(newUserCart);
    }

    public void deleteItem(UUID userID, String itemToBeDeleted) {
        Cart currentUserCart = cartRepository.findById(userID)
                .orElse(null);
        currentUserCart.getCartItems().remove(itemToBeDeleted);
        cartRepository.save(currentUserCart);
    }

    public void addItemToCart(UUID userID, String itemToBeAdded) {
        Cart currentUserCart = cartRepository.findById(userID)
                .orElse(null);
        currentUserCart.getCartItems().add(itemToBeAdded);
        cartRepository.save(currentUserCart);
    }

    public double getTotalCartAmount() {
        // Calculate total cart amount logic here
        return 0.0;
    }
}
