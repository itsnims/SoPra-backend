package ch.uzh.ifi.seal.soprafs18.GameLogic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndGameManagerTest {

    Game game = new Game();
    Player player = new Player();
    Player player2 = new Player();
    EndGameManager endGameManager = new EndGameManager(game);

    @Test
    public void checkifReached() {
        Boolean reached = endGameManager.checkifReached();
        Assert.assertEquals(false,reached);
        game.getWinners().add(player);
        Boolean reached2 = endGameManager.checkifReached();
        Assert.assertEquals(true,reached2);


    }

    @Test
    public void getWinner() {
        player.setBlockadePoints(2);
        player2.setBlockadePoints(4);
        game.getWinners().add(player);
        endGameManager.getWinner();
        Assert.assertEquals(player,game.getWinner());
        game.getWinners().add(player2);
        endGameManager.getWinner();
        Assert.assertEquals(player2,game.getWinner());



    }
}