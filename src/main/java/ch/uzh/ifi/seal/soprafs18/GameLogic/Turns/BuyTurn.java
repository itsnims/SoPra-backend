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
        for (int i = 0; i < market.MarketBottom.size(); i++) {
            Object obj = market.MarketBottom.get(i);
            Card check = (Card)obj;
            if (check.getName().equals(cardToBuy.getName())) {

                market.MarketBottom.remove(check);
                market.getBottomdict().put(check.getName(),market.getBottomdict().get(check.getName())-1);
                if(market.getBottomdict().get(check.getName()) == 0){
                    market.currentBottomCards = market.currentBottomCards-1;
                }

                break outerloop;
            }

        }

    }


    public boolean IsUpperCard() {
        Boolean isUpper = false;

        for (int i = 0; i < market.MarketUpper.size(); i++) {
            Object obj = market.MarketUpper.get(i);
            Card check = (Card)obj;
            if (check.getName().equals(cardToBuy.getName())) {
                CardDeck.add(check);
                isUpper = true;

            }
        }
        return isUpper;
    }



    public double enoughmoney(){
        int x = 0;
        double sum = 0;
        while (selectedCards.size() > x) {
            sum = sum + selectedCards.get(x).getPrice();
            x = x + 1;
        }
        return sum;

    }

    @Override
    public void turnfunction () {



        if (IsUpperCard()) {
            market.getCardsfromUpper(CardDeck);
            market.getUpperdict().put(CardDeck.get(0).getName(),0);


            for (String key : market.bottomdict.keySet()) {
                if(market.getBottomdict().get(key)== 0){
                    market.getBottomdict().remove(key);

                    break;
                }
            }
            market.getBottomdict().put(CardDeck.get(0).getName(),CardDeck.size());
            market.MarketBottom.addAll(CardDeck);





        }


        currentPlayer.discardpile.add(cardToBuy);
        currentPlayer.selection.addAll(selectedCards);
        currentPlayer.handcards.removeAll(selectedCards);
        /**means we have used this card **/
        DeleteFromMarket();

        //else : buying is not possible
    }


}

