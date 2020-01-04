package mtds.microservices.order.dao;

import mtds.microservices.order.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao  extends CrudRepository<Product, Long> {
}
