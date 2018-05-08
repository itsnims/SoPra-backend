package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance
public abstract class BoardPiece {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    public int Strenght;


    public String Color;

    public BoardPiece(){}


    public BoardPiece( String color) {
        this.Color=color;

    }

    @JsonIgnore
    public String getColor() {
        return Color;
    }

    public void setStrenght(int strenght) {
        Strenght = strenght;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
