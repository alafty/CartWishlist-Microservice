package com.RAAF.CartWishlist.Wishlist;

import com.RAAF.CartWishlist.CartWishlistMicroserviceApplication;
import com.RAAF.CartWishlist.Command;
import com.RAAF.CartWishlist.Wishlist.Commands.AddItem;
import com.RAAF.CartWishlist.Wishlist.Commands.AddUser;
import com.RAAF.CartWishlist.Wishlist.Commands.DeleteItem;
import com.RAAF.CartWishlist.Wishlist.Commands.ViewWishlist;
import com.RAAF.CartWishlist.dto.Item;
import com.RAAF.CartWishlist.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "wishlist/v1/")
@Component
public class WishlistController {
    private final WishlistService wishlistService;
    private RabbitMQProducer producer;

    @Autowired
    public WishlistController(WishlistService wishlistService, RabbitMQProducer producer) {
        this.producer = producer;
        this.wishlistService = wishlistService;
    }

    //DONE
    @GetMapping
    public Set<String> viewWishlist() {
        Command viewWishList = new ViewWishlist(this.wishlistService);
        return viewWishList.executeGet();
    }

    //DONE
    @PostMapping
    public void addUser(@RequestBody String newUserID) {
        System.out.println(newUserID);
        Command addUser = new AddUser(this.wishlistService);
        addUser.execute(newUserID);
    }

    //DONE
    @PutMapping
    public void addItemToWishlist(@RequestBody Item itemID) {
        Command addIem = new AddItem(this.wishlistService);
        addIem.execute(itemID.id);
    }

    //DONE
    @DeleteMapping
    public void deleteItem(@RequestBody Item itemID) {
        Command deleteItem = new DeleteItem(this.wishlistService);
        deleteItem.execute(itemID.id);
    }
}
