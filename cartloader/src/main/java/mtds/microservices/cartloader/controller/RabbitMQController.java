package mtds.microservices.cartloader.controller;

import mtds.microservices.cartloader.model.CartOrder;
import mtds.microservices.cartloader.service.RabbitMQSender;
import mtds.microservices.cartloader.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/cart-rabbitmq/")
@JsonComponent
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @CrossOrigin
    @PostMapping(value = "/producer")
    public String producer(@RequestBody CartOrder cartOrder) {

        System.out.println(cartOrder);
        CartOrder newCartOrder = new CartOrder(cartOrder.getAmount());

        rabbitMQSender.send(newCartOrder);

        return new ResponseFactory().build(newCartOrder).serialize();
    }
}
