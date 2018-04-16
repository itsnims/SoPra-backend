package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Field extends BoardPiece {

    @Id
    private String name;

    @Transient
    @JsonIgnore
    public boolean TrashCards;

    @Transient
    @JsonIgnore
    public List<BoardPiece> neighbours = new ArrayList<>();

    @Transient
    @JsonIgnore
    public boolean Accessable; /** not taken */

    public Field(int strenght, String color, boolean PlayAnyCard, boolean TrashCard, boolean Accessable) {
        super(strenght, color, PlayAnyCard);
        this.Accessable=Accessable;
        this.TrashCards=TrashCard;

    }

    public boolean getAccessable(){
        return Accessable;
    }

    public boolean getTrashCards(){
        return TrashCards;
    }

    public void AddNewNeighbour(BoardPiece neighbour, BoardPiece... boardPieces){
        neighbours.add(neighbour);
        if (boardPieces.length > 0){
            for(int i=0; i < boardPieces.length; i++){
                neighbours.add(boardPieces[i]);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
