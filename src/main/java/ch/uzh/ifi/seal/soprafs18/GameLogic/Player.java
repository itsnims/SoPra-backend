package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    public List<Card> drawpile = new ArrayList<Card>(80);
    public List<Card> handcards = new ArrayList<Card>(80);
    public List<Card> discardcards = new ArrayList<Card>(80);
    private String Playercolor;
    private Boolean Turn;
    private Integer BlockadePoints;

    public Player(String playercolor) {
        ExpeditionCard Sailor = new ExpeditionCard("Sailor", "Blue", true, 0.5, 1);
        ExpeditionCard Explorer1 = new ExpeditionCard("Explorer", "Green", true, 0.5, 1);
        ExpeditionCard Explorer2 = new ExpeditionCard("Explorer", "Green", true, 0.5, 1);
        ExpeditionCard Explorer3 = new ExpeditionCard("Explorer", "Green", true, 0.5, 1);
        ExpeditionCard Explorer4 = new ExpeditionCard("Explorer", "Green", true, 0.5, 1);
        ExpeditionCard Traveler1 = new ExpeditionCard("Traveler", "Yellow", true, 0.5, 1);
        ExpeditionCard Traveler2 = new ExpeditionCard("Traveler", "Yellow", true, 0.5, 1);
        ExpeditionCard Traveler3 = new ExpeditionCard("Traveler", "Yellow", true, 0.5, 1);
        ExpeditionCard Traveler4 = new ExpeditionCard("Traveler", "Yellow", true, 0.5, 1);
        drawpile.add(Sailor);
        drawpile.add(Explorer1);
        drawpile.add(Explorer2);
        drawpile.add(Explorer3);
        drawpile.add(Explorer4);
        drawpile.add(Traveler1);
        drawpile.add(Traveler2);
        drawpile.add(Traveler3);
        drawpile.add(Traveler4);
        this.Playercolor = playercolor;

        /**this.drawpile = drawpile;
         this.handcards=handcards;
         this.discardcards=discardcards;

         this.Turn=Turn;
         this.BlockadePoints=BlockadePoints;  do i need to self assign here or nah?**/
    }

    public void addtoDrawPile(ArrayList<Card> Cards) {
        drawpile.addAll(Cards);

    }

    public void drawCards() {
        int currentInHand = handcards.size();
        if (currentInHand < 4) {
            Collections.shuffle(drawpile);
            handcards.add(drawpile.get(0));
            drawpile.remove(0);
            currentInHand = currentInHand + 1;
        }

    }

    public void discardCard(ArrayList<Card> Cards) {
        discardcards.addAll(Cards);
        handcards.removeAll(Cards);
        /** this only removes selected cards.. how do we automatically remove played cards?? **/
    }

    public void setBlockadePoints(Integer blockadePoints) {
        BlockadePoints = blockadePoints;
    }

}


