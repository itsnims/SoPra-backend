package ch.uzh.ifi.seal.soprafs18.GameLogic;


public class Figure {

    public int currentPosition;
    public String Color;


    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getCurrentPosition() {
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
