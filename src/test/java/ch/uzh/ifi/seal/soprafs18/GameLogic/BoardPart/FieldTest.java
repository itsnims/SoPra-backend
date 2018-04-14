package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FieldTest {

    private Field field = new Field(0,"Green",false,false,true);
    private Field fieldToAdd = new Field(1,"Green",false,false,true);

    @Test
    public void addNewNeighbour() {
        field.AddNewNeighbour(fieldToAdd);
        Assert.assertEquals(fieldToAdd, field.neighbours.get(0));
    }

    @Test
    public void getaccessable() {
        boolean result = field.getAccessable();
        Assert.assertEquals(true,result);
    }

    @Test
    public void getTrashCard() {
        boolean result = field.getTrashCards();
        Assert.assertEquals(false ,result);
    }
}
