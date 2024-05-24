package com.RAAF.CartWishlist.Cart;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Set<String> viewCart(String userID) {
        Cart currentCart = cartRepository.findById(userID)
                .orElse(null);
        if(currentCart == null) {
            addUser(userID);
            currentCart = cartRepository.findById(userID)
                    .orElse(null);
        }
        return currentCart.getCartItems();
    }

    public void addUser(String newUserID) {
        Cart newUserCart = new Cart(newUserID, new HashSet<>(List.of("")));
        cartRepository.save(newUserCart);
    }

    public void addItemToCart(String userID, String itemToBeAdded) {
        Cart currentUserCart = cartRepository.findById(userID).orElse(null);

        if (currentUserCart == null) {
            addUser(userID);
            currentUserCart = cartRepository.findById(userID).orElse(null);
        }
        currentUserCart.getCartItems().add(itemToBeAdded);
        cartRepository.save(currentUserCart);
    }


    public void deleteItem(String userID, String itemToBeDeleted) {
        Cart currentUserCart = cartRepository.findById(userID)
                .orElse(null);
        currentUserCart.getCartItems().remove(itemToBeDeleted);
        cartRepository.save(currentUserCart);
    }

    public void emptyCart(String userID) {
        Cart currentUserCart = cartRepository.findById(userID)
                .orElse(null);
        currentUserCart.getCartItems().clear();
        currentUserCart.getCartItems().add("");
        cartRepository.save(currentUserCart);
    }

    public double getTotalCartAmount(String userID) {
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
