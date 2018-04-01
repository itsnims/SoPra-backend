package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;

public class MarketActionCard extends ActionCard {

    public MarketActionCard(String name,String cardColour, Boolean reusable,Integer Price){
        super(name,cardColour,reusable,Price);
    }

    @Override
    public void doSpecialFunction(Player player) {;
        /** does nothing so far but will execute buy once Market is implemented, will go directly buy instead of calling turn in order
         * to preserve to one use of Buy
          */
        /**/
    }
}
