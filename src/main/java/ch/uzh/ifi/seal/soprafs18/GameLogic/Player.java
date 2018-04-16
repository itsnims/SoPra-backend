package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity

public class Player {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(unique = true)
    private String name;

    @OneToMany
    public List<Card> drawpile = new ArrayList<Card>(80);

    @OneToMany
    public List<Card> handcards = new ArrayList<Card>(80);

    @OneToMany
    public List<Card> discardpile = new ArrayList<Card>(80);

    @Transient
    @JsonIgnore
    public List<Card> trashpile = new ArrayList<Card>(80);

    @OneToMany
    public List<Card> selection = new ArrayList<>(80);

    @OneToOne
    public Figure myFigure;
    /**
     * made each player a unique trash since the starter cards have the same name for all.
     */
    public PlayerColor PlayerColor;
    private Boolean Turn;
    private Integer BlockadePoints = 0;


    public Player() {
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

    public void setBlockadePoints(Integer blockadePoints) {

        BlockadePoints = blockadePoints;
    }

    public Integer getBlockadePoints() {
        return BlockadePoints;
    }

    public void addtoTrash(List<Card> Cards){
        trashpile.addAll(Cards);

    }

    public void setMyFigure(Figure myFigure) {
        this.myFigure = myFigure;
    }

    public void setTurn(Boolean turn){
        this.Turn = turn;
    }

    public boolean getTurn(){
        return this.Turn;
    }

    public void executeTurn(Turn turn){
        turn.turnfunction();
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getID() { return Id; }

    public void setPlayerColor(ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor playerColor) {
        PlayerColor = playerColor;
    }

    public ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor getPlayerColor() {
        return PlayerColor;
    }
}

