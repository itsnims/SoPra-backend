package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;

import java.util.ArrayList;
import java.util.List;

public class ElDorado  {
    private boolean reached;
    private List<Player> Reachers = new ArrayList<>(4);


    public ElDorado(){
        reached=false;
    }

    public void setReached(){
        reached=true;
    }

    public boolean isReached(){
        return reached;
    }

    public void AddReacher(Player player){
        Reachers.add(player);
    }

    public List<Player> getReachers() {
        return Reachers;
    }
}
