package com.RAAF.CartWishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CartWishlistMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartWishlistMicroserviceApplication.class, args);
	}

    public static List<Object> getTempUser() {
		return null;
	}
}
