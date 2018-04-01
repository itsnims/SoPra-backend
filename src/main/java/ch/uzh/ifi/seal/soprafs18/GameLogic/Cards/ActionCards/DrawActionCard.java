package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;

import java.util.ArrayList;
import java.util.Collections;

public class DrawActionCard extends ActionCard {

    private Boolean TrashSome; /** tells us if it gives us the trash option **/
    private Integer HowMany; /** tell us how many we can draw **/

    public DrawActionCard(String name,String cardColour, Boolean reusable,Integer Price,Integer HowMany, Boolean TrashSome){
        super(name,cardColour,reusable,Price);
        this.TrashSome = TrashSome;
        this.HowMany= HowMany;
    }

    @Override
    public void doSpecialFunction(){
        int number = 0;
        while (number < HowMany) {
            Collections.shuffle(Player.drawpile); /** i cant figure it out..makes me create a new player instance but i dont want that.. **/
            Player.handcards.add(Player.drawpile.get(0));
            Player.drawpile.remove(0);
            number = number + 1;

        }



    }
}
