package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Field extends BoardPiece {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;


    private String name;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    public List<BoardPiece> neighbours = new ArrayList<>();


    @JsonIgnore
    public boolean Accessable;

    @JsonIgnore
    int Strenght;

    /**
     * not taken
     */

    public Field(){

    }

    public Field(int strenght, String color, boolean Accessable,String name) {
        super(color);
        this.Accessable = Accessable;
        this.name = name;
        this.Strenght = strenght;


    }


    public boolean getAccessable() {
        return Accessable;
    }


    public boolean setAccessable(boolean set) {
        return Accessable = set;
    }


    @JsonIgnore
    public void AddNewNeighbour(BoardPiece neighbour, BoardPiece... boardPieces) {
        neighbours.add(neighbour);
        if (boardPieces.length > 0) {
            for (int i = 0; i < boardPieces.length; i++) {
                neighbours.add(boardPieces[i]);
            }
        }
    }




    @JsonIgnore
    public Blockade getBlockadeFromNeighbours() {
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i) instanceof Blockade) {
                return (Blockade) neighbours.get(i);
            }
        }
        return null;
    }



    public List<BoardPiece> getNeighbours() {
        return neighbours;
    }




    @JsonIgnore
    private Boolean getUsable(String Color, int Strenght,Field compare) {
        if (compare.getColor().equals(Color)) if (Strenght >= compare.getStrenght()) if (compare.getAccessable())return true;
        if (compare.getColor().equals("White")) if (compare.getAccessable()) return true;
        if (compare.getColor().equals("Camp")) if (compare.getAccessable()) return true;
        return false;
    }

    /** returns all fields reachable from start tile with given color and strenght **/

    @JsonIgnore
    public List<BoardPiece> getAll (String Color, int Strenght,Field field){


        List<BoardPiece> list = new ArrayList<>();
        for (int i = 0; i < field.getNeighbours().size(); i++) {
            BoardPiece piece = field.getNeighbours().get(i);
            if (piece instanceof Blockade) {
                if (((Blockade) piece).getStrenght() <= Strenght && piece.getColor().equals(Color)) {
                    list.add(piece);
                }

            }
            else {
                Field neighbour = (Field) piece;
                if (getUsable(Color, Strenght, neighbour)) {
                    if (neighbour.getStrenght() > 0) {
                        list.add(neighbour);
                    }
                    if (neighbour.getStrenght() > 0) {
                        int newStrenght = Strenght - neighbour.getStrenght();
                        if ((newStrenght) > 0) {
                            System.out.println(newStrenght);
                            list.addAll(getAll(Color, newStrenght, neighbour));
                        }
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

    public void setNeighbours(List<BoardPiece> neighbours) {
        this.neighbours = neighbours;
    }

    public void setStrenght(int strenght) {
        Strenght = strenght;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAccessable() {
        return Accessable;
    }


    public Long getId() {
        return id;
    }
}
