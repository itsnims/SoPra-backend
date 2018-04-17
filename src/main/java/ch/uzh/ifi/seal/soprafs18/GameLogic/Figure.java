package ch.uzh.ifi.seal.soprafs18.GameLogic;


import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;


@Entity
public class Figure {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long Id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Field currentPosition = null;


    public void setCurrentPosition(Field currentPosition) {
        this.currentPosition = currentPosition;
    }


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
}
