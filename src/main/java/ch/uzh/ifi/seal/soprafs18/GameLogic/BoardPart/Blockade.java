package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Entity
public class Blockade extends BoardPiece {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;


    private String name;


    @JsonIgnore
    private int Strenght;


    @JsonIgnore
    public boolean crossed;




    @JsonIgnore
    @Transient
    private List<Field> neighbours = new ArrayList<>();

    public Blockade(){}

    public Blockade(String name,int Strenght,String Color, boolean crossed) {
        super(Color);
        this.Strenght = Strenght;
        this.crossed=crossed;
        this.name = name;

    }

    public void setCrossed(){
        crossed=true;
    }

    public boolean getCrossed(){
        return crossed;
    }

    public void givePoints(Player player){
        player.setBlockadePoints(Strenght);
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

    public void setStrenght(int strenght) {
        Strenght = strenght;
    }



    public List<Field> getNeighbours(){
        return neighbours;
    }


    public void setNeighbours(List<Field> neighbours) {
        this.neighbours = neighbours;
    }


    public void addNeighbour(Field field, Field... fields){
        neighbours.add(field);
        if (fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
                neighbours.add(fields[i]);
            }
        }
    }



    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
