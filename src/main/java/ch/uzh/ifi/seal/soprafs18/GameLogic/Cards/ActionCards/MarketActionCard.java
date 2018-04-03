package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.BuyTurn;

public class MarketActionCard extends ActionCard {
    private Market market;
    private Card choice;
    private Player player;

    public MarketActionCard(String name,String cardColour, Boolean reusable,Integer Price){
        super(name,cardColour,reusable,Price);
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setChoice(Card choice) {
        this.choice = choice;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void doSpecialFunction() {
        BuyTurn exection = new BuyTurn();
        exection.getCardtoBuy(choice);
        exection.deletefromMarket(market);
        player.discardpile.add(choice);
    }
}

