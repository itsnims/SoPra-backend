package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long Id;

    @Column(unique = true)
    private String name;

    @Column
    private Integer BlockadePoints = 0;

    @Column
    private PlayerColor PlayerColor;

    @Column
    private Boolean Turn;


    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL})
    public List<Card> drawpile = new ArrayList<Card>(80);


    @OneToMany(cascade = {CascadeType.ALL})
    public List<Card> handcards = new ArrayList<Card>(80);

    @Transient
    @JsonIgnore
    public List<Card> trashpile = new ArrayList<Card>(80);


    @OneToMany(cascade = {CascadeType.ALL})
    public List<Card> discardpile = new ArrayList<Card>(80);

    @OneToMany(cascade = {CascadeType.ALL})
    public List<Card> selection = new ArrayList<>(80);

    @OneToOne(cascade = {CascadeType.ALL})
    public Figure myFigure = new Figure();


    public Player() {

    }

    public void setup() {
        ExpeditionCard Sailor = new ExpeditionCard("Sailor", "Blue", true, 0.5, 1);
        ExpeditionCard Explorer1 = new ExpeditionCard("Explorer", "Green", true, 0.5, 1);
        ExpeditionCard Explorer2 = new ExpeditionCard("Explorer", "Green", true, 0.5, 1);
        ExpeditionCard Explorer3 = new ExpeditionCard("Explorer", "Green", true, 0.5, 1);
        ExpeditionCard Traveler1 = new ExpeditionCard("Traveler", "Yellow", true, 0.5, 1);
        ExpeditionCard Traveler2 = new ExpeditionCard("Traveler", "Yellow", true, 0.5, 1);
        ExpeditionCard Traveler3 = new ExpeditionCard("Traveler", "Yellow", true, 0.5, 1);
        ExpeditionCard Traveler4 = new ExpeditionCard("Traveler", "Yellow", true, 0.5, 1);
        drawpile.add(Sailor);
        drawpile.add(Explorer1);
        drawpile.add(Explorer2);
        drawpile.add(Explorer3);
        drawpile.add(Traveler1);
        drawpile.add(Traveler2);
        drawpile.add(Traveler3);
        drawpile.add(Traveler4);
    }


    public void setBlockadePoints(Integer blockadePoints) {

        BlockadePoints = BlockadePoints + blockadePoints;
    }

    public Integer getBlockadePoints() {
        return BlockadePoints;
    }

    public void addtoTrash(List<Card> Cards) {
        trashpile.addAll(Cards);

    }

    public void setMyFigure(Figure myFigure) {
        this.myFigure = myFigure;
    }


    public void executeTurn(Turn turn) {
        turn.turnfunction();
    }


    public void setPlayerColor(ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor playerColor) {
        PlayerColor = playerColor;
    }

    public ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor getPlayerColor() {
        return PlayerColor;
    }

    public void addtoDrawPile(List<Card> Cards) {
        drawpile.addAll(Cards);
    }

    public void drawCards() {
        int currentInHand = handcards.size();
        while (currentInHand < 4) {
            Collections.shuffle(drawpile);
            handcards.add(drawpile.get(0));
            drawpile.remove(0);
            currentInHand = currentInHand + 1;
        }

    }

    public void discardCard(List<Card> Cards) {
        discardpile.addAll(Cards);
        handcards.removeAll(Cards);
    }

    public Boolean getTurn() {
        return Turn;
    }

    public void setTurn(Boolean turn) {
        Turn = turn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void reset(){
        handcards.clear();
        discardpile.clear();
        trashpile.clear();
        selection.clear();
        setMyFigure(null);
        setTurn(null);
        resetPoints();
        setPlayerColor(null);


    }



    public Figure getMyFigure() {
        return myFigure;
    }

    public void resetPoints(){
        BlockadePoints = 0;
    }

    public Card getWantedCard(String cardname){
        for(int i = 0; i < handcards.size(); i++){
            if(cardname.equals(handcards.get(i).getName()));
            return handcards.get(i);
        }

        return null;

    }


}

