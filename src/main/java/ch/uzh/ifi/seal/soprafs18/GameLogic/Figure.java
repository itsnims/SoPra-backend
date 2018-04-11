package ch.uzh.ifi.seal.soprafs18.GameLogic;


import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;

public class Figure {

    public Field currentPosition;
    public String Color;


    public void setCurrentPosition(Field currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setColor(String color) {
        Color = color;
    }

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
