package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Board;

public class Field extends BoardPiece {

    public boolean TrashCards;
    public boolean Accessable; /** not taken */
    public boolean Cave;

    public Field(int strenght, String color, boolean PlayAnyCard, boolean TrashCard, boolean Accessable, boolean Cave) {
        super(strenght, color, PlayAnyCard);
        this.Accessable=Accessable;
        this.TrashCards=TrashCard;
        this.Cave= Cave;
    }

    public boolean getAccessable(){
        return Accessable;
    }

    public boolean getTrashCards(){
        return TrashCards;
    }

    public boolean getCave(){
        return Cave;
    }

}
