package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayExpeditionCardTest {
    ExpeditionCard Scout1 = new ExpeditionCard("Scout","Green",true,1,2);
    Player currentplayer = new Player();
    List<ExpeditionCard> selectedCards = new ArrayList<>();

    @Test
    public void turnfunction() {
        currentplayer.setup();
        currentplayer.setPlayerColor(PlayerColor.BLUE);
        selectedCards.add(Scout1);
        currentplayer.handcards.addAll(selectedCards);
        PlayExpeditionCard playsth = new PlayExpeditionCard(selectedCards,currentplayer);
        playsth.turnfunction();
        Assert.assertEquals(1, currentplayer.selection.size());
        Assert.assertEquals(0, currentplayer.handcards.size());

    }
}