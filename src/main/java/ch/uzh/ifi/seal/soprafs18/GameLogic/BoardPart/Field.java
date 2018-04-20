package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Path;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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

    @JsonIgnore
    @Transient
    int Strenght;

    /**
     * not taken
     */

    public Field(){

    }
    @JsonIgnore
    public Field(int strenght, String color, boolean Accessable,String name) {
        super(color);
        this.Accessable = Accessable;
        this.name = name;
        this.Strenght = strenght;


    }

    @Transient
    @JsonIgnore
    public boolean getAccessable() {
        return Accessable;
    }

    @Transient
    @JsonIgnore
    public void AddNewNeighbour(BoardPiece neighbour, BoardPiece... boardPieces) {
        neighbours.add(neighbour);
        if (boardPieces.length > 0) {
            for (int i = 0; i < boardPieces.length; i++) {
                neighbours.add(boardPieces[i]);
            }
        }
    }



    @Transient
    @JsonIgnore
    public Blockade getBlockadeFromNeighbours() {
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i) instanceof Blockade) {
                return (Blockade) neighbours.get(i);
            }
        }
        return null;
    }

    @Transient
    @JsonIgnore
    public List<BoardPiece> getNeighbours() {
        return neighbours;
    }

    @Transient
    @JsonIgnore
    public Boolean getUsable(String Color, int Strenght,Field compare) {
        if (compare.getColor().equals(Color) && Strenght>=compare.getStrenght()) {
            return true;
        } else {

            return false;
        }
    }

    /** returns all fields reachable from start tile with given color and strenght **/
    @Transient
    @JsonIgnore
    public List<BoardPiece> getAll (String Color, int Strenght,Field field){
        System.out.println("im inside the function");

        List<BoardPiece> list = new ArrayList<>();
        for (int i = 0; i < field.getNeighbours().size(); i++){
            BoardPiece piece = field.getNeighbours().get(i);
            Field neighbour = (Field) piece;
            System.out.println("im in for");
            if(getUsable(Color,Strenght,neighbour)){
                list.add(neighbour);
                System.out.println("im at the neighbour");
                if (neighbour.getStrenght()>0){
                   int newStrenght = Strenght - neighbour.getStrenght();
                    if ((newStrenght) > 0) {
                        System.out.println(newStrenght);
                        list.addAll(getAll(Color, newStrenght, neighbour));
                    }
                }

            }
        }
        return list;


    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStrenght() {
        return Strenght;
}
}
