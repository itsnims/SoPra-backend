package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;

public class DrawActionCard extends ActionCard {

    private Boolean TrashSome; /** tells us if it gives us the trash option **/
    private Integer HowMany; /** tell us how many we can draw **/

    public DrawActionCard(String name,String cardColour, Boolean reusable,Integer Price,Integer HowMany, Boolean TrashSome){
        super(name,cardColour,reusable,Price);
        this.TrashSome = TrashSome;
        this.HowMany= HowMany;
    }

    @Override
    public void doSpecialFunction() {
        /** implement after player class , manipulate draw stack **/


    }
}
