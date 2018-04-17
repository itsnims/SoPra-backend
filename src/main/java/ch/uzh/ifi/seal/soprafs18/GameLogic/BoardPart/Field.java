package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Field extends BoardPiece {

    @Id
    private String name;

    @Transient
    @JsonIgnore
    public List<BoardPiece> neighbours = new ArrayList<>();

    @Transient
    @JsonIgnore
    public boolean Accessable;

    /**
     * not taken
     */

    public Field(int strenght, String color, boolean Accessable, String name) {
        super(strenght, color);
        this.name = name;
        this.Accessable = Accessable;

    }

    public boolean getAccessable() {
        return Accessable;
    }

    public void AddNewNeighbour(BoardPiece neighbour, BoardPiece... boardPieces) {
        neighbours.add(neighbour);
        if (boardPieces.length > 0) {
            for (int i = 0; i < boardPieces.length; i++) {
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

    public Blockade getBlockadeFromNeighbours() {
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i) instanceof Blockade) {
                return (Blockade) neighbours.get(i);
            }
        }
        return null;
    }
}
