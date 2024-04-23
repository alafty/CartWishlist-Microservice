package com.RAAF.CartWishlist;

import com.RAAF.CartWishlist.Wishlist.Wishlist;
import com.RAAF.CartWishlist.Wishlist.WishlistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
			wishlistRepository.deleteAll();

			Wishlist w1 = new Wishlist(UUID.randomUUID(), new String[]{"John"});
			Wishlist w2 = new Wishlist(UUID.randomUUID(),new String[]{"Jane"});
			Wishlist savedJohn = wishlistRepository.save(w1);
			Wishlist savedJane = wishlistRepository.save(w2);

			wishlistRepository.findAll()
					.forEach(v -> log.info("Vet: {}", v.getFirstName()));

			wishlistRepository.findById(savedJohn.getId())
					.ifPresent(v -> log.info("Vet by id: {}", v.getFirstName()));
		};
	}
}



