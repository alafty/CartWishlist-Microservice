package com.RAAF.CartWishlist;

import com.RAAF.CartWishlist.Cart.Cart;
import com.RAAF.CartWishlist.Cart.CartRepository;
import com.RAAF.CartWishlist.Wishlist.Wishlist;
import com.RAAF.CartWishlist.Wishlist.WishlistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping
public class CartWishlistMicroserviceApplication {
	public static ArrayList<String> tempUser = new ArrayList<>();

	public static String activeUserID = "";
	public static void main(String[] args) {
		SpringApplication.run(CartWishlistMicroserviceApplication.class, args);
	}

	@GetMapping
	public String FetchAll() {
		return "Welcome to the Wishlist Main page";
	}
	@Bean
	public CommandLineRunner clr(WishlistRepository wishlistRepository, CartRepository cartRepository) {
		return args -> {
			wishlistRepository.deleteAll();
			cartRepository.deleteAll();
			String user1 = "user1";
			tempUser.add(user1);
			String user2 = "user2";
			tempUser.add(user2);
			String user3 = "user3";
			tempUser.add(user3);
			Wishlist w1 = new Wishlist(user1,  new HashSet<>(Arrays.asList("item2", "item4", "item6","item8")));
			Wishlist w2 = new Wishlist(user2, new HashSet<>(Arrays.asList("item2, item6")));
			Wishlist w3 = new Wishlist(user3, new HashSet<>(Arrays.asList("item8")));
			Cart c1 = new Cart(user1, new HashSet<>(Arrays.asList("item1", "item3", "item5", "item7")));
			Cart c2 = new Cart(user2, new HashSet<>(Arrays.asList("item1", "item3")));
			Cart c3 = new Cart(user3, new HashSet<>(Arrays.asList("item5")));



			Wishlist savedJohn = wishlistRepository.save(w1);
			wishlistRepository.save(w2);
			wishlistRepository.save(w3);

			Cart savedCart = cartRepository.save(c1);
			cartRepository.save(c2);
			cartRepository.save(c3);


			wishlistRepository.findAll()
					.forEach(w -> System.out.println(w.getWishlistItems()));

			wishlistRepository.findById(user1)
					.ifPresent(v -> System.out.println(" u: " + v.getUserID()));

			cartRepository.findAll()
					.forEach(w -> System.out.println(w.getCartItems()));

			cartRepository.findById(user1)
					.ifPresent(v -> System.out.println(v.getUserID()));

		};
	}

	public static ArrayList<String> getTempUser() {
		return tempUser;
	}
}



