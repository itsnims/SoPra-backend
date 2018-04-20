package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Transient;

public abstract class BoardPiece {

    @JsonIgnore
    @Transient
    public int Strenght;
    @JsonIgnore
    @Transient
    public String Color;

    public BoardPiece(){}

    @JsonIgnore
    public BoardPiece( String color) {
        this.Color=color;

    }

    @JsonIgnore
    @Transient
    public String getColor() {
        return Color;
    }


}
