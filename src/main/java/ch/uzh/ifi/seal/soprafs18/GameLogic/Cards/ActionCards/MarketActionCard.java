package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.BuyTurn;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("M")
public class MarketActionCard extends ActionCard {

    @JsonIgnore
    @Transient
    private Market market;
    @JsonIgnore
    @Transient
    private Card marketCard;
    @JsonIgnore
    @Transient
    private Player player;

    public MarketActionCard(){

    }

    public MarketActionCard(String name, String cardColour, Boolean reusable, Integer Price) {
        super(name, cardColour, reusable, Price);
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setChoice(Card choice) {
        this.marketCard = choice;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Market getMarket() {
        return market;
    }

    @Override
    public void doSpecialFunction() {}

}


