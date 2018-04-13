package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;

import java.util.ArrayList;
import java.util.List;

public class ElDorado  {
    private boolean reached;
    private List<Player> Reachers = new ArrayList<>(4);
    public static ElDorado instance = null;


    public ElDorado(){
        reached=false;
    }

    public static ElDorado getInstance(){
        if(instance == null){
            instance = new ElDorado();
        }
        return instance;
    }

    public void setReached(){
        reached=true;
    }

    public boolean getReached(){ return reached; }

    public void AddReacher(Player player){
        Reachers.add(player);
    }

    public List<Player> getReachers() {
        return Reachers;
    }
}
