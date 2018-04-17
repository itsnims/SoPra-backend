package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BlockadeTest {

    private Blockade blockade= new Blockade(1, "green", false);
    private Player player= new Player();
    private Field A = new Field(0,"Green",true, "test");

    @Test
    public void setCrossed() {
        blockade.setCrossed();
        Assert.assertEquals(true, blockade.getCrossed());
    }

    @Test
    public void getcrossed() {
        boolean result = blockade.getCrossed();
        Assert.assertEquals(false,result);
    }

    @Test
    public void removeBlockade(){
        Field B37 = new Field(1,"Green",true, "B37");
        Field B33 = new Field(1,"Green",true, "B33");
        Field B28 = new Field(1,"Green",true, "B28");
        Field B22 = new Field(1,"Blue",true, "B22");
        Blockade blockade= new Blockade(1, "Blue", false);
        B22.AddNewNeighbour(B28,blockade);
        B28.AddNewNeighbour(B22,B33,blockade);
        B33.AddNewNeighbour(B28,B37, blockade);
        B37.AddNewNeighbour(B33, blockade);

        Field C1 = new Field(1,"Blue",true, "C1");
        Field C2 = new Field(1,"Blue",true, "C2");
        Field C3 = new Field(1,"Green",true, "C3");
        Field C4 = new Field(1,"Green",true, "C4");
        C1.AddNewNeighbour(C2);
        C2.AddNewNeighbour(C1,C3);
        C3.AddNewNeighbour(C2,C4);
        C4.AddNewNeighbour(C3);

        blockade.removeBlockade(true, B37, B33, B28, B22, C1,C2, C3, C4);
        Assert.assertEquals(B33, B37.neighbours.get(0));
        Assert.assertEquals(C1, B37.neighbours.get(1));
        Assert.assertEquals(C2, B37.neighbours.get(2));
    }

    @Test
    public void givePoints() {
        blockade.givePoints(player);
        int actual = player.getBlockadePoints();
        Assert.assertEquals(1,actual);
    }
}
