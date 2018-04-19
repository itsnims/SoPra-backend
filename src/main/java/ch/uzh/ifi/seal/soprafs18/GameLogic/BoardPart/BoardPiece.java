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
    public BoardPiece(int strenght, String color) {
        this.Color=color;
        this.Strenght=strenght;
    }
    @JsonIgnore
    @Transient
    public int getStrenght() {
        return Strenght;
    }
    @JsonIgnore
    @Transient
    public String getColor() {
        return Color;
    }


}
