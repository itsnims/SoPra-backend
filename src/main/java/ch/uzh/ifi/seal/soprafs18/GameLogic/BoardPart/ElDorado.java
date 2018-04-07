package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Board;

public class ElDorado  {
    public boolean reached;

    public ElDorado(){
        reached=false;
    }

    public void setReached(){
        reached=true;
    }

    public boolean isReached(){
        return reached;
    }

}
