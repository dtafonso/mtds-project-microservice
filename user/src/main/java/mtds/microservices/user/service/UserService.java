package mtds.microservices.user.service;

import mtds.microservices.user.dao.UserDao;
import mtds.microservices.user.model.User;
import mtds.microservices.user.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Configurable
public class UserService {

    @Autowired
    UserDao userDao;


    public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
        return this.userDao.save(newUser);
    }

}
