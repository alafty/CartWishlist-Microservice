package com.RAAF.CartWishlist.userMQ;

import com.RAAF.CartWishlist.dto.User;
import com.RAAF.CartWishlist.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users/mq/")
public class userMQController {

    private RabbitMQProducer producer;

    public userMQController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> sendActiveUser(@RequestBody User user) {
        System.out.println("Got-It");
        producer.sendMessage(user);
        return ResponseEntity.ok("User ID sent to RabbitMQ ...");
    }
}
