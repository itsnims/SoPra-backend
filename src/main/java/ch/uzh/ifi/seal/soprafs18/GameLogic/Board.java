package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;

import java.util.ArrayList;
import java.util.List;

public class Board {

    /** public Path path; --> zu path gehört auch ElDorado, da es 2 gibt */
    public List<Blockade> Blockades= new ArrayList<>(6);

    Blockade blockade4= new Blockade(1,"blue",false, false);
    Blockade blockade2= new Blockade(1,"yellow",false, false);
    Blockade blockade1= new Blockade(1,"green",false, false);
    Blockade blockade5= new Blockade(2,"green",false, false);
    Blockade blockade6= new Blockade(2,"white",true, false);   /** if blockade is white: play (blockade points) cards to cross, any card is acceptable */
    Blockade blockade3= new Blockade(1,"white",true, false);

    /** Blockades.add(blockade1);
    Blockades.add(blockade2);
    Blockades.add(blockade3);
    Blockades.add(blockade4);
    Blockades.add(blockade5);
    Blockades.add(blockade6);
     */


    public Board(){

    }

    /**
    public void setBlockades(Path path) {
    } --> shuffle all blockades and put needed number of blockades between tiles
     */


}
