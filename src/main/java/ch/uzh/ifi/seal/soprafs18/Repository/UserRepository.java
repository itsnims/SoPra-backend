package ch.uzh.ifi.seal.soprafs18.Repository;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Player, Long> {
    Player findByName(String name);
    List<Player> deleteByName(String name);

}