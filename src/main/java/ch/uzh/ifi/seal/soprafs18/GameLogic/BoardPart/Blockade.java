package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Blockade extends BoardPiece {

    private String name;

    public boolean crossed;
    public List<Field> neighbours= new ArrayList<>();

    public Blockade(String name,int Strenght,String Color, boolean crossed) {
        super(Strenght,Color);
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
}
