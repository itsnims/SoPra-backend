package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Board;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;

public class Blockade extends BoardPiece {

    public boolean crossed;

    public Blockade(int Strenght,String Color, boolean PlayAnyCard, boolean crossed) {
        super(Strenght,Color,PlayAnyCard);
        this.crossed=crossed;

    }

    public void setCrossed(){
        crossed=true;
    }

    public boolean getCrossed(){
        return crossed;
    }

    public void removeBlockade(){
        if (crossed){
            Strenght=0;
            Color= "pink"; /** no pink blockades*/
        }
    }

    public void givePoints(Player player){
        player.setBlockadePoints(player.getBlockadePoints()+Strenght);
    }

}
