package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turn;


import java.util.List;

public class BuyTurn implements Turn {
    private Card cardToBuy;
    private List<Card> selectedCards;
    private Player currentPlayer;
    public List<Card> CardDeck;


    public void BuyTurn(List<Card> selection, Player player) {
        this.selectedCards = selection;
        this.currentPlayer = player;
    }

    public void getCardtoBuy(Card BuyThis) {
        this.cardToBuy = BuyThis;
    }

    public void deletefromMarket(Market market) {

        outerloop:
        for (int i = 0; i < market.BottomCards.size(); i++) {
            for (int j = 0; j < market.BottomCards.get(i).size(); j++) {
                if (market.BottomCards.get(i).get(j) == cardToBuy) {
                    market.BottomCards.get(i).remove(j);
                    market.LeftonDeckBottom(market.BottomCards.get(i));
                    break outerloop;
                }
            }
        }
    }


    public boolean IsUpperCard(Market market) {
        outerloop:
        for (int i = 0; i < market.UpperCards.size(); i++) {
            for (int j = 0; j < market.UpperCards.get(i).size(); j++) {
                if (market.UpperCards.get(i).get(j) == cardToBuy)
                    CardDeck = market.UpperCards.get(j);
                    return true;
            }
        }
        return false;
    }

    @Override
    public void turnfunction () {
        int i = 0;
        int x = 0;
        double sum = 0;
        while (selectedCards.size() >= x) {
            sum = sum + selectedCards.get(x).getPrice();
            x = x + 1;
        }
        if (cardToBuy.getPrice() <= sum) {
            if (IsUpperCard(Market.getInstance()) && Market.getInstance().isfree()) {
                Market.getInstance().getCardsfromUpper(CardDeck);
            }

            currentPlayer.discardpile.add(cardToBuy);
            currentPlayer.selection.addAll(selectedCards);
            currentPlayer.handcards.removeAll(selectedCards);
            /**means we have used this card **/

            deletefromMarket(Market.getInstance());

            //else : buying is not possible
        }

    }
}


