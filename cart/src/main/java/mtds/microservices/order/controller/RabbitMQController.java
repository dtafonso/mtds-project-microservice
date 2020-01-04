package mtds.microservices.order.controller;

import mtds.microservices.order.model.Order;
import mtds.microservices.order.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order-rabbitmq/")
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("productName") String productName, @RequestParam("quantity") String quantity) {

        Order order = new Order();
        order.setProductName(productName);
        order.setQuantity(Integer.parseInt(quantity));
        rabbitMQSender.send(order);

        return "Message sent to the RabbitMQ orderqueue Successfully";
    }
}
