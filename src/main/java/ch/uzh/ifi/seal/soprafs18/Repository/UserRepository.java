package ch.uzh.ifi.seal.soprafs18.Repository;

import ch.uzh.ifi.seal.soprafs18.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
    List<User> deleteByName(String name);

}