package com.RAAF.CartWishlist;

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
	public static ArrayList<UUID> tempUser = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(CartWishlistMicroserviceApplication.class, args);
	}

	@GetMapping
	public String FetchAll() {
		return "Welcome to the Wishlist Main page";
	}
	@Bean
	public CommandLineRunner clr(WishlistRepository wishlistRepository) {
		return args -> {
			wishlistRepository.deleteAll();

			UUID user1 = UUID.randomUUID();
			tempUser.add(user1);
			UUID user2 = UUID.randomUUID();
			tempUser.add(user2);
			UUID user3 = UUID.randomUUID();
			tempUser.add(user3);
			Wishlist w1 = new Wishlist(user1,  new HashSet<>(Arrays.asList("CACJN0CI0Q8HQ2", "KFDH9QD8YJ12@", "LJASBUCAICBA$","UGD86@3IOYRKJ")));
			Wishlist w2 = new Wishlist(user2, new HashSet<>(Arrays.asList("")));
			Wishlist w3 = new Wishlist(user3, new HashSet<>(Arrays.asList("WDLJBQFI$7")));

			Wishlist savedJohn = wishlistRepository.save(w1);
			wishlistRepository.save(w2);
			wishlistRepository.save(w3);


			wishlistRepository.findAll()
					.forEach(w -> System.out.println(w.getWishlistItems()));

			wishlistRepository.findById(user1)
					.ifPresent(v -> System.out.println(v.getUserID()));
		};
	}

	public static ArrayList<UUID> getTempUser() {
		return tempUser;
	}
}



