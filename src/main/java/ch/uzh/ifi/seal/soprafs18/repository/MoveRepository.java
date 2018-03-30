package ch.uzh.ifi.seal.soprafs18.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Move;

@Repository("moveRepository")
public interface MoveRepository extends CrudRepository<Move, Long> {
}
