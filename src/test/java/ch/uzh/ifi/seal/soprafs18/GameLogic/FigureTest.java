package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FigureTest {

    private Field field = new Field(0,"Green",false,false,true);
    private Figure figure= new Figure();

    @Test
    public void setCurrentPosition() {
        figure.setCurrentPosition(field);
        Assert.assertEquals(field, figure.getCurrentPosition());
    }

    @Test
    public void setColor() {
        figure.setColor("white");
        Assert.assertEquals("white", figure.getColor());
    }

    @Test
    public void getColor(){
        figure.setColor("green");
        String result = figure.getColor();
        Assert.assertEquals("green", result);
    }

    @Test
    public void getCurrentPosition() {
        figure.setCurrentPosition(field);
        Field result= figure.getCurrentPosition();
        Assert.assertEquals(field, result);
    }

    @Test
    public void moveFigure() {
    }
}