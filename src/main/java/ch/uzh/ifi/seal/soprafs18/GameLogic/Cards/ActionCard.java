package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("A")
public abstract class ActionCard extends Card {

    public ActionCard(String name,String cardColour,Boolean reusable, Integer Price){
        super(name,cardColour,reusable,Price);
    }
    public abstract void doSpecialFunction();


}
