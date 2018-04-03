package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.DrawActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.EndTurn;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.PlayActionCard;

public class tests {

    public static void main(String[] args) {
        Player nimra = new Player("Green");
        Figure smallnimra = new Figure();

        nimra.setMyFigure(smallnimra);
        nimra.myFigure.setColor(nimra.Playercolor);
        nimra.myFigure.setCurrentPosition(1);

        nimra.drawCards();


        ActionCard Draw2 = new DrawActionCard("Forscher", "purple", true, 1, 2, false);
        nimra.handcards.add(Draw2);

        /***
         *
         */

        PlayActionCard clickbutton = new PlayActionCard(Draw2,nimra);
        nimra.executeTurn(clickbutton);

        EndTurn finisj = new EndTurn(nimra);
        nimra.executeTurn(finisj);

        System.out.println(nimra.handcards.size());
        /**
         * is corrected, starts with 4 card plus 1 draw2card = 5 cards.
         * uses draw2, removes draw2 from hand, puts into selection = 4Cards
         * the function adds 2 additional cards to handcard = 6
         */
        System.out.println(nimra.selection.size());
        System.out.println(nimra.discardpile.size());






    }
}


