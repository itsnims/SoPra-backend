package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TileTest {

    private Field field = new Field(0,"Green",false,false,true);
    private Tile tile= new Tile();

    @Test
    public void addFields() {
        tile.AddFields(field);
        Assert.assertEquals(field, tile.getField(0));
    }

    @Test
    public void GetField(){
        tile.AddFields(field);
        Field result = tile.getField(0);
        Assert.assertEquals(field, result);
    }
}