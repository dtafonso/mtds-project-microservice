package mtds.microservices.productselect.service;

import mtds.microservices.productselect.model.Product;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${product-selection-queue.rabbitmq.exchange}")
    private String exchange;

    @Value("${product-selection-queue.rabbitmq.routingkey}")
    private String routingkey;

    public void send(List<Product> productsList) {
        rabbitTemplate.convertAndSend(exchange, routingkey, productsList);
        System.out.println("Selected Product Rabbitmq Sent msg = " + productsList);

    }
}
