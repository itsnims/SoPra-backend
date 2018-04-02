package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;


public class MoveActionCard extends ActionCard {
    Player player;
    int position;

    public MoveActionCard(String name,String cardColour, Boolean reusable,Integer Price){
        super(name,cardColour,reusable,Price);
    }
    public void setPlayer(Player player){
        this.player = player;

    }

    public void positionChoice(int choice){
        this.position=choice;
    }

    @Override
    public void doSpecialFunction() {
        /**get new position over rest.
         *
         */
        player.myFigure.setCurrentPosition(position);

    }
}




