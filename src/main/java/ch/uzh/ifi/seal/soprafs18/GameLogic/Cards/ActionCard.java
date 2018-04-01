package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;

public abstract class ActionCard extends Card {

    public ActionCard(String name,String cardColour,Boolean reusable, Integer Price){
        super(name,cardColour,reusable,Price);
    }
    public abstract void doSpecialFunction(Player player);

}
