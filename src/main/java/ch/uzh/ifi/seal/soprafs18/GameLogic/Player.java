package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private List<Card> drawpile = new ArrayList<Card>(80);
    ExpeditionCard Sailor = new ExpeditionCard("Sailor","Blue",true,0.5,1);
    ExpeditionCard Explorer1 = new ExpeditionCard("Explorer","Green",true,0.5,1);
    ExpeditionCard Explorer2 = new ExpeditionCard("Explorer","Green",true,0.5,1);
    ExpeditionCard Explorer3 = new ExpeditionCard("Explorer","Green",true,0.5,1);
    ExpeditionCard Explorer4 = new ExpeditionCard("Explorer","Green",true,0.5,1);
    ExpeditionCard Traveler1 = new ExpeditionCard("Traveler","Yellow",true,0.5,1);
    ExpeditionCard Traveler2 = new ExpeditionCard("Traveler","Yellow",true,0.5,1);
    ExpeditionCard Traveler3 = new ExpeditionCard("Traveler","Yellow",true,0.5,1);
    ExpeditionCard Traveler4 = new ExpeditionCard("Traveler","Yellow",true,0.5,1);
    private List<Card> handcards = new ArrayList<Card>(80);
    private List<Card> discardcards = new ArrayList<Card>(80);
    private String Playercolor;
    private Boolean Turn;
    private Integer BlockadePoints;

    public Player(String playercolor) {
        drawpile.add(Sailor);
        drawpile.add(Explorer1);
        drawpile.add(Explorer2);
        drawpile.add(Explorer3);
        drawpile.add(Explorer4);
        drawpile.add(Traveler1);
        drawpile.add(Traveler2);
        drawpile.add(Traveler3);
        drawpile.add(Traveler4);
        this.drawpile = drawpile;
        this.handcards=handcards;
        this.discardcards=discardcards;
        this.Playercolor=playercolor;
        this.Turn=Turn;
        this.BlockadePoints=BlockadePoints;
    }

    





}
