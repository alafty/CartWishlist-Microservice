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

@SpringBootApplication
@RestController
@RequestMapping
public class CartWishlistMicroserviceApplication {
	private final static Logger log = LoggerFactory.getLogger(CartWishlistMicroserviceApplication.class);

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

			Wishlist w1 = new Wishlist(UUID.randomUUID(),  new HashSet<>(Arrays.asList("BikoSiko")));
			Wishlist w2 = new Wishlist(UUID.randomUUID(), new HashSet<>(Arrays.asList("SikoTiko")));
			Wishlist savedJohn = wishlistRepository.save(w1);
			wishlistRepository.save(w2);

			wishlistRepository.findAll()
					.forEach(w -> System.out.println(w.getWishlistItems()));

			wishlistRepository.findById(savedJohn.getUserID())
					.ifPresent(v -> log.info("Vet by id: {}", v.getUserID()));
		};
	}
}



