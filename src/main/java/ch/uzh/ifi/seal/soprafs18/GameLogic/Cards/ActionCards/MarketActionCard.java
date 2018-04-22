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

    public MarketActionCard(String name, String cardColour, Boolean reusable, Integer Price) {
        super(name, cardColour, reusable, Price);
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
        boolean Found = false;

        outerloop:

        for (int i = 0; i < market.BottomCards.size(); i++) {
            for(int j = 0;j < market.BottomCards.get(i).size(); j++) {
                Object obj = market.BottomCards.get(i).get(j);
                Card check = (Card)obj;
                if (check.getName() == choice.getName()) {
                    market.BottomCards.get(i).remove(check);
                    market.RemoveIfEmpty(market.BottomCards.get(i));
                    Found = true;
                    break outerloop;
                }

            }
        }

        if (Found == false) {
            secondloop:
            for (int i = 0; i < market.UpperCards.size(); i++) {
                for (int j = 0; j < market.UpperCards.get(i).size(); j++) {
                    Object obj = market.UpperCards.get(i).get(j);
                    Card card = (Card)obj;
                    if (card.getName() == choice.getName()) {
                        market.UpperCards.get(i).remove(0);
                        break secondloop;
                    }
                }
            }

        }
        player.discardpile.add(choice);
    }
}


