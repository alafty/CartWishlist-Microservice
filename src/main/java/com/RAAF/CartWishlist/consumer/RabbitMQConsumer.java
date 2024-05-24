package com.RAAF.CartWishlist.consumer;

import com.RAAF.CartWishlist.dto.User;
import com.RAAF.CartWishlist.publisher.RabbitMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(User user) {
        LOGGER.info(String.format("Message received -> %s", user));

    }

}
