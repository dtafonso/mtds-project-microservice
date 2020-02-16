package mtds.microservices.cartconfirm.service;

import mtds.microservices.cartconfirm.model.CartOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${cart-confirm-queue.rabbitmq.exchange}")
    private String exchange;

    @Value("${cart-confirm-queue.rabbitmq.routingkey}")
    private String routingkey;

    public void send(CartOrder cartOrder) {
        rabbitTemplate.convertAndSend(exchange, routingkey, cartOrder);
        System.out.println("Cart Confirmation sent to Order using Rabbitmq = " + cartOrder);

    }
}
