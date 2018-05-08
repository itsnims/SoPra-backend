package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
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

    @Transient
    @JsonIgnore
    public List<Field> neighbours= new ArrayList<>();

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

    /** tell method if the first tile is set higher than the next one or not (to bind the correct fields)*/
    public void removeBlockade(boolean HigherThanOtherTile, Field f1, Field f2, Field f3, Field f4, Field f5, Field f6,Field f7, Field f8) {
        if (crossed) {
            for (int i=0; i<f1.neighbours.size();i++){
                if (f1.neighbours.get(i) instanceof Blockade){
                    f1.neighbours.remove(i);
                }
            }
            for (int i=0;i<f2.neighbours.size();i++){
                if (f2.neighbours.get(i) instanceof Blockade){
                    f2.neighbours.remove(i);
                }
            }
            for (int i=0;i<f3.neighbours.size();i++){
                if (f3.neighbours.get(i) instanceof Blockade){
                    f3.neighbours.remove(i);
                }
            }
            for (int i=0;i<f4.neighbours.size();i++){
                if (f4.neighbours.get(i) instanceof Blockade){
                    f4.neighbours.remove(i);
                }
            }
            if (HigherThanOtherTile) {
                f1.AddNewNeighbour(f5, f6);
                f2.AddNewNeighbour(f6, f7);
                f3.AddNewNeighbour(f7, f8);
                f4.AddNewNeighbour(f8);
                f5.AddNewNeighbour(f1);
                f6.AddNewNeighbour(f1, f2);
                f7.AddNewNeighbour(f2, f3);
                f8.AddNewNeighbour(f3, f4);
            } else {
                f1.AddNewNeighbour(f5);
                f2.AddNewNeighbour(f5, f6);
                f3.AddNewNeighbour(f6, f7);
                f4.AddNewNeighbour(f7, f8);
                f5.AddNewNeighbour(f1, f2);
                f6.AddNewNeighbour(f2, f3);
                f7.AddNewNeighbour(f3, f4);
                f8.AddNewNeighbour(f4);
            }
        }
    }

    public void givePoints(Player player){
        player.setBlockadePoints(player.getBlockadePoints()+Strenght);
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

    public void BlockadeCross(boolean Higher){
        Field f1 = getNeighbours().get(0);
        Field f2 = getNeighbours().get(1);
        Field f3 = getNeighbours().get(2);
        Field f4 = getNeighbours().get(3);
        Field f5 = getNeighbours().get(4);
        Field f6 = getNeighbours().get(5);
        Field f7 = getNeighbours().get(6);
        Field f8 = getNeighbours().get(7);


        if (Higher) {
            f1.AddNewNeighbour(f5, f6);
            f2.AddNewNeighbour(f6, f7);
            f3.AddNewNeighbour(f7, f8);
            f4.AddNewNeighbour(f8);
            f5.AddNewNeighbour(f1);
            f6.AddNewNeighbour(f1, f2);
            f7.AddNewNeighbour(f2, f3);
            f8.AddNewNeighbour(f3, f4);
        } else {
            f1.AddNewNeighbour(f5);
            f2.AddNewNeighbour(f5, f6);
            f3.AddNewNeighbour(f6, f7);
            f4.AddNewNeighbour(f7, f8);
            f5.AddNewNeighbour(f1, f2);
            f6.AddNewNeighbour(f2, f3);
            f7.AddNewNeighbour(f3, f4);
            f8.AddNewNeighbour(f4);
        }

    }


    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
