package com.RAAF.CartWishlist.Wishlist;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.Commands.AddItem;
import com.RAAF.CartWishlist.Wishlist.Commands.AddUser;
import com.RAAF.CartWishlist.Wishlist.Commands.DeleteItem;
import com.RAAF.CartWishlist.Wishlist.Commands.ViewWishlist;
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
        Command viewWishList = new ViewWishlist(this.wishlistService);
        return viewWishList.executeGet();
    }

    @PostMapping
    public void addUser(@RequestBody String newUserID) {
        System.out.println(newUserID);
        Command addUser = new AddUser(this.wishlistService);
        addUser.execute(UUID.fromString(newUserID));
    }

    @PutMapping
    public void addItemToWishlist(@RequestBody String userID, String itemID) {
        //TODO: Make sure to actually send the UUID when integrating
        System.out.println(itemID);
        Command addIem = new AddItem(this.wishlistService);
        addIem.execute(CartWishlistMicroserviceApplication.getTempUser().get(0), "CACJN0CI0Q8HQ2");
    }

    @DeleteMapping
    public void deleteItem(@RequestBody String userID, String itemID) {
        //TODO: Make sure to actually send the UUID and actual String when integrating
        Command deleteItem = new DeleteItem(this.wishlistService);
        deleteItem.execute(CartWishlistMicroserviceApplication.getTempUser().get(0), itemID);
    }
}
