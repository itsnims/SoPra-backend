package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards;


import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class ExpeditionCard extends Card {
    private Integer CardStrenght;

    public ExpeditionCard(){}

    public ExpeditionCard(String name, String cardColour, Boolean reusable, double Price,Integer CardStrenght) {
        super(name,cardColour,reusable,Price);
        this.CardStrenght = CardStrenght;
    }

    public Integer getCardStrenght() {
        return CardStrenght;
    }
}

