package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Board;

import java.util.ArrayList;
import java.util.List;

public class Field extends BoardPiece {

    public boolean TrashCards;
    public List<BoardPiece> neighbours = new ArrayList<>();
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

}
