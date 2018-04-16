package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ElDoradoTest {

    private ElDorado elDorado= new ElDorado();
    private Player player = new Player();



    @Test
    public void getInstance() {
        ElDorado result = elDorado.getInstance();
        Assert.assertEquals(elDorado.instance, result);
    }

    @Test
    public void setReached() {
        elDorado.setReached();
        Assert.assertEquals(true, elDorado.getReached());
    }

    @Test
    public void getReached() {
        boolean result= elDorado.getReached();
        Assert.assertEquals(false, result);
    }

    @Test
    public void addReacher() {
        elDorado.AddReacher(player);
        Assert.assertEquals(player, elDorado.getReachers().get(0));
    }

    @Test
    public void getReachers() {
        ArrayList<Player> list= new ArrayList<>();
        elDorado.AddReacher(player);
        list.add(player);
        Assert.assertEquals(list, elDorado.getReachers());
    }
}