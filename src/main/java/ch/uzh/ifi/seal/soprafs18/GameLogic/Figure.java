package ch.uzh.ifi.seal.soprafs18.GameLogic;


import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Figure {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToOne
    private Field currentPosition = null;

    @Transient
    @JsonIgnore
    private PlayerColor Color;


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


    public Long getId() {
        return Id;
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
