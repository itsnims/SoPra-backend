package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
        Blockade blockade= new Blockade("test",1, "Blue", false);
        field.AddNewNeighbour(fieldToAdd, blockade);
        Blockade result= field.getBlockadeFromNeighbours();
        Assert.assertEquals(blockade, result);
    }

    @Test
    public void getOptionsTest(){
        Field A1 = new Field(1,"Green",true,"A1");
        Field A2 = new Field(2,"Green",true,"A2");
        Field A3 = new Field(2,"Green",true,"A3");
        Field A4 = new Field(2,"Red",true,"A4");
        Field A5 = new Field(1,"Green",true,"A5");
        Field A6 = new Field(1,"Green",true,"A6");
        Blockade B1 = new Blockade("B1",1,"Green",false);
        ExpeditionCard movetest;
        movetest = new ExpeditionCard("Sailor","Green",false,2,4);

        A1.AddNewNeighbour(A2,A3,A4);
        A2.AddNewNeighbour(A5,B1);
        A5.AddNewNeighbour(A6);
        List<BoardPiece> options = A1.getAll(movetest.getCardColour(),movetest.getCardStrenght(),A1);
        Assert.assertEquals(7,options.size());
    }

}
