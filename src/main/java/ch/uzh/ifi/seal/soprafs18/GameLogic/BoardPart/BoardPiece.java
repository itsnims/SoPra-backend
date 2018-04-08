package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

public abstract class BoardPiece {
    public int Strenght;
    public String Color;
    public boolean PlayAnyCard;

    public BoardPiece(int strenght,String color, boolean PlayAnyCard) {
        this.Color=color;
        this.Strenght=strenght;
        this.PlayAnyCard=PlayAnyCard;
    }

    public int getStrenght() {
        return Strenght;
    }

    public String getColor() {
        return Color;
    }

    public boolean PlayAnyCard(){
        return PlayAnyCard;
    }
}
