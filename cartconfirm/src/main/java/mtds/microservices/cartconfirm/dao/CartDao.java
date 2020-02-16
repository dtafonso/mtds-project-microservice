package mtds.microservices.cartconfirm.dao;

import mtds.microservices.cartconfirm.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends CrudRepository<Cart, Long> {
    Cart findTopByOrderByIdDesc();
}
