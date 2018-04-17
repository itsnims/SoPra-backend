package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

public abstract class BoardPiece {
    public int Strenght;
    public String Color;

    public BoardPiece(int strenght, String color) {
        this.Color=color;
        this.Strenght=strenght;
    }

    public int getStrenght() {
        return Strenght;
    }

    public String getColor() {
        return Color;
    }

}
