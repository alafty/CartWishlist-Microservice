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

    public Set<String> viewCart(UUID userID) {
        System.out.println("I'mHere");
        Cart currentCart = cartRepository.findById(CartWishlistMicroserviceApplication.tempUser.get(0))
                .orElse(null);
        return currentCart.getCartItems();
    }

    public void addUser(UUID newUserID) {
        Cart newUserCart = new Cart(CartWishlistMicroserviceApplication.tempUser.get(0), new HashSet<>(List.of("")));
        cartRepository.save(newUserCart);
    }

    public void addItemToCart(UUID userID, String itemToBeAdded) {
        Cart currentUserCart = cartRepository.findById(CartWishlistMicroserviceApplication.tempUser.get(0)).orElse(null);

        if (currentUserCart == null) {
            addUser(CartWishlistMicroserviceApplication.tempUser.get(0));
            currentUserCart = cartRepository.findById(CartWishlistMicroserviceApplication.tempUser.get(0)).orElse(null);
        }
        currentUserCart.getCartItems().add("itemToBeAdded");
        cartRepository.save(currentUserCart);
    }


    public void deleteItem(UUID userID, String itemToBeDeleted) {
        Cart currentUserCart = cartRepository.findById(CartWishlistMicroserviceApplication.tempUser.get(0))
                .orElse(null);
        currentUserCart.getCartItems().remove("itemToBeDeleted");
        cartRepository.save(currentUserCart);
    }

    public void emptyCart(UUID userID) {
        Cart currentUserCart = cartRepository.findById(CartWishlistMicroserviceApplication.tempUser.get(0))
                .orElse(null);
        currentUserCart.getCartItems().clear();
        cartRepository.save(currentUserCart);
    }

    public double getTotalCartAmount(UUID userID) {
        Cart currentCart = cartRepository.findById(userID).orElse(null);

        if (currentCart == null) {
            return 0.0;
        }

        Set<Double> currentCartPrices = currentCart.getCartItemsPrices();
        double totalAmount = 0.0;

        for (Double price : currentCartPrices) {
            totalAmount += price;
        }

        return totalAmount;
    }

}
