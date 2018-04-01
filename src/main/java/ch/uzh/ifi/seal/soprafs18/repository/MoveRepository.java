package ch.uzh.ifi.seal.soprafs18.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("moveRepository")
public interface MoveRepository extends CrudRepository<Move, Long> {
}
