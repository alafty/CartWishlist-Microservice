package com.RAAF.CartWishlist.Wishlist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

    public List viewWishlist() {
        return List.of("1",new String[]{"1", "3"});
    }
}
