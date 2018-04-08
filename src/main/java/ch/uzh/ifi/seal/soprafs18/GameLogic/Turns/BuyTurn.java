package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turn;


import java.util.ArrayList;
import java.util.List;

public class BuyTurn implements Turn {
    private Card cardToBuy;
    private List<Card> selectedCards = new ArrayList<>();
    private Player currentPlayer;
    public List<Card> CardDeck = new ArrayList<>();
    private Market market;


    public BuyTurn(List<Card> selection, Player player) {
        this.selectedCards = selection;
        this.currentPlayer = player;
    }

    public void getCardtoBuy(Card BuyThis) {
        this.cardToBuy = BuyThis;
    }

    public Card CardToBuy() {
        return cardToBuy;
    }

    public void setMarket(Market market) {
        this.market = market;
    }


    public void DeleteFromMarket() {

        outerloop:
        for (int i = 0; i < market.BottomCards.size(); i++) {
            for (int j = 0; j < market.BottomCards.get(i).size(); j++) {
                Object obj = market.BottomCards.get(i).get(j);
                Card check = (Card)obj;
                if (check.getName() == cardToBuy.getName()) {
                    market.BottomCards.get(i).remove(check);
                    market.LeftonDeckBottom(market.BottomCards.get(i));
                    break outerloop;
                }

            }
        }
    }


    public boolean IsUpperCard() {

        for (int i = 0; i < market.UpperCards.size(); i++) {
            for (int j = 0; j < market.UpperCards.get(i).size(); j++) {
                Object obj = market.UpperCards.get(i).get(j);
                Card check = (Card)obj;
                if (check.getName() == cardToBuy.getName()) {
                    CardDeck.addAll(market.UpperCards.get(i));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void turnfunction () {
        int x = 0;
        double sum = 0;
        while (selectedCards.size() > x) {
            sum = sum + selectedCards.get(x).getPrice();
            x = x + 1;
        }

        if (cardToBuy.getPrice() <= sum) {
            if (IsUpperCard() && market.isfree()) {
                market.getCardsfromUpper(CardDeck);
            }
            currentPlayer.discardpile.add(cardToBuy);
            currentPlayer.selection.addAll(selectedCards);
            currentPlayer.handcards.removeAll(selectedCards);
            /**means we have used this card **/

            DeleteFromMarket();

            //else : buying is not possible
        }

    }
}


