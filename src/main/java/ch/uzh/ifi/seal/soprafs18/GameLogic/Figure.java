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

    @Column
    private String figureName;


    public void setCurrentPosition(Field currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setName(String name){
        this.figureName = name;
    }

    public String getName(){
        return figureName;
    }

    public Field getCurrentPosition() {
        return currentPosition;
    }

    @JsonIgnore
    public Long getId() {
        return Id;
    }


    public Figure(){

    }
}
