package com.RAAF.CartWishlist.Wishlist;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.Set;

@RestController
@RequestMapping(path = "wishlist/v1/")
@Component
public class WishlistController {
    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping
    public Set<String> viewWishlist() {
        return wishlistService.viewWishlist();
    }

    @PostMapping
    public void addUser(@RequestBody String newUserID) {
        //TODO: Make sure to actually send the UUID when integrating
        System.out.println(newUserID);
        wishlistService.addUser(UUID.randomUUID());
    }

    @PutMapping
    public void addItemToWishlist(@RequestBody String userID, String itemID) {
        //TODO: Make sure to actually send the UUID when integrating
        System.out.println(itemID);
        wishlistService.addItemToWishlist(CartWishlistMicroserviceApplication.getTempUser().get(0), "CACJN0CI0Q8HQ2");
    }

    @DeleteMapping
    public void deleteItem(@RequestBody String userID, String itemID) {
        //TODO: Make sure to actually send the UUID and actual String when integrating
        wishlistService.deleteItem(CartWishlistMicroserviceApplication.getTempUser().get(0), "CACJN0CI0Q8HQ2");
    }
}
