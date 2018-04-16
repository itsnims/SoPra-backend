package ch.uzh.ifi.seal.soprafs18.Repository;

        import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
        import org.springframework.data.repository.CrudRepository;

        import java.util.List;

public interface GameRepository extends CrudRepository<Game,Long> {
    Game findByName(String name);
    List<Game> deleteByName(String name);
    

}
