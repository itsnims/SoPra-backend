package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    List<Field> Tile = new ArrayList<>();

    public Tile(){

    }

    public void AddFields(Field A,Field...fields){
        Tile.add(A);
        if(fields.length>0){
            for(int i=0;i<fields.length;i++){
                Tile.add(fields[i]);
            }
        }

    }

    public Field getField(int index){
       return Tile.get(index);
    }
}
