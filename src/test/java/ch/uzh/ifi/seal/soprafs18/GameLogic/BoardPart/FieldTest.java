package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FieldTest {

    private Field field = new Field(0,"Green",true, "test");
    private Field fieldToAdd = new Field(1,"Green",true, "test");

    @Test
    public void addNewNeighbour() {
        field.AddNewNeighbour(fieldToAdd);
        Assert.assertEquals(fieldToAdd, field.neighbours.get(0));
    }

    @Test
    public void getAccessable() {
        boolean result = field.getAccessable();
        Assert.assertEquals(true,result);
    }

    @Test
    public void getName(){
        String result= field.getName();
        Assert.assertEquals("test", result);
    }

    @Test
    public void setName(){
        field.setName("test1");
        Assert.assertEquals("test1", field.getName());
    }

    @Test
    public void getBlockadeFromNeighbours(){
        Blockade blockade= new Blockade(1, "Blue", false);
        field.AddNewNeighbour(fieldToAdd, blockade);
        Blockade result= field.getBlockadeFromNeighbours();
        Assert.assertEquals(blockade, result);
    }

}
