package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity
@DiscriminatorValue("F")
public class MoveActionCard extends ActionCard {

    @JsonIgnore
    @Transient
    Player player;
    @JsonIgnore
    @Transient
    Field position;

    public MoveActionCard(){

    }

    public MoveActionCard(String name,String cardColour, Boolean reusable,Integer Price){
        super(name,cardColour,reusable,Price);
    }
    public void setPlayer(Player player){
        this.player = player;

    }

    @JsonIgnore
    @Transient
    public void positionChoice(Field choice){
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



