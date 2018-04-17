package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FigureTest {

    private Field field = new Field(0,"Green",true,"test");
    private Figure figure= new Figure();

    @Test
    public void setCurrentPosition() {
        figure.setCurrentPosition(field);
        Assert.assertEquals(field, figure.getCurrentPosition());
    }

    @Test
    public void setColor() {
        figure.setColor(PlayerColor.WHITE);
        Assert.assertEquals(PlayerColor.WHITE, figure.getColor());
    }

    @Test
    public void getColor(){
        figure.setColor(PlayerColor.WHITE);
        PlayerColor result = figure.getColor();
        Assert.assertEquals(PlayerColor.WHITE, result);
    }

    @Test
    public void getCurrentPosition() {
        figure.setCurrentPosition(field);
        Field result= figure.getCurrentPosition();
        Assert.assertEquals(field, result);
    }

}