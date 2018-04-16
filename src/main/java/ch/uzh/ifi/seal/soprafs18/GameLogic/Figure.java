package ch.uzh.ifi.seal.soprafs18.GameLogic;


import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;

public class Figure {

    public Field currentPosition;
    public PlayerColor Color;


    public void setCurrentPosition(Field currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setColor(PlayerColor color) {
        Color = color;
    }

    public PlayerColor getColor(){return Color;}

    public Field getCurrentPosition() {
        return currentPosition;
    }

    /** am anfang farbe zuteilen
     *
     */

    public Figure(){

    }

    public void moveFigure(){
        /**needs to be moveable over: field, blockade and eldorado */
    }
}
