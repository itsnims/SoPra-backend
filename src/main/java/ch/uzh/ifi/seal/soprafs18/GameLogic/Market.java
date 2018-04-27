package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.DrawActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MarketActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MoveActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.*;


@Entity
public class Market {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @JsonIgnore
    @Transient
    public List<List<Card>> BottomCards = new ArrayList<>();

    @JsonIgnore
    @Transient
    public List<List<Card>> UpperCards = new ArrayList<>(12);

    @Transient
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL})
    private Integer currentBottomCards = 6;
    @Transient
    @JsonIgnore
    private static Market instance = null;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL})
    public List<Card> MarketBottom;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL})
    public List<Card> MarketUpper;

    @Column(columnDefinition="LONGTEXT")
    public LinkedHashMap<String,Integer> upperdict = new LinkedHashMap<>();
    @Column(columnDefinition="LONGTEXT")
    public LinkedHashMap<String,Integer> bottomdict = new LinkedHashMap<>();


    public Market(){ }
    public void marketsetup(){

        List<Card> MarketDeckPlane = new ArrayList<>(3);
        List<Card> MarketDeckAdventurer = new ArrayList<>(3);
        List<Card> MarketDeckPioneer = new ArrayList<>(3);
        List<Card> MarketDeckMighty = new ArrayList<>(3);
        List<Card> MarketDeckJournalist = new ArrayList<>(3);
        List<Card> MarketDeckMillionaire = new ArrayList<>(3);
        List<Card> MarketDeckCartopgrapher = new ArrayList<>(3);
        List<Card> MarketDeckCompass = new ArrayList<>(3);
        List<Card> MarketDeckTravelDiary = new ArrayList<>(3);
        List<Card> MarketDeckScientist = new ArrayList<>(3);
        List<Card> MarketDeckNatives = new ArrayList<>(3);
        List<Card> MarketDeckCaptain = new ArrayList<>(3);


        ExpeditionCard Scout1 = new ExpeditionCard("Scout","Green",true,1,2);
        ExpeditionCard Scout2 = new ExpeditionCard("Scout","Green",true,1,2);
        ExpeditionCard Scout3 = new ExpeditionCard("Scout","Green",true,1,2);


        ExpeditionCard Trailblazer1 = new ExpeditionCard("Trailblazer","Green",true,3,3);
        ExpeditionCard Trailblazer2 = new ExpeditionCard("Trailblazer","Green",true,3,3);
        ExpeditionCard Trailblazer3 = new ExpeditionCard("Trailblazer","Green",true,3,3);


        ExpeditionCard AllRounder1 = new ExpeditionCard("Allrounder","White",true,2,1);
        ExpeditionCard AllRounder2 = new ExpeditionCard("Allrounder","White",true,2,1);
        ExpeditionCard AllRounder3 = new ExpeditionCard("Allrounder","White",true,2,1);


        ExpeditionCard Photographer1 = new ExpeditionCard("Photographer","Yellow",true,2,2);
        ExpeditionCard Photographer2 = new ExpeditionCard("Photographer","Yellow",true,2,2);
        ExpeditionCard Photographer3 = new ExpeditionCard("Photographer","Yellow",true,2,2);


        ExpeditionCard TreasureChest1 = new ExpeditionCard("TreasureChest","Yellow",false,3,4);
        ExpeditionCard TreasureChest2 = new ExpeditionCard("TreasureChest","Yellow",false,3,4);
        ExpeditionCard TreasureChest3 = new ExpeditionCard("TreasureChest","Yellow",false,3,4);


        MarketActionCard TelephoneTerminal1 = new MarketActionCard("Transmitter","Purple",false,4);
        MarketActionCard TelephoneTerminal2 = new MarketActionCard("Transmitter","Purple",false,4);
        MarketActionCard TelephoneTerminal3 = new MarketActionCard("Transmitter","Purple",false,4);


        MarketBottom.add(Scout1);
        MarketBottom.add(Scout2);
        MarketBottom.add(Scout3);
        MarketBottom.add(Trailblazer1);
        MarketBottom.add(Trailblazer2);
        MarketBottom.add(Trailblazer3);
        MarketBottom.add(AllRounder1);
        MarketBottom.add(AllRounder2);
        MarketBottom.add(AllRounder3);
        MarketBottom.add(Photographer1);
        MarketBottom.add(Photographer2);
        MarketBottom.add(Photographer3);
        MarketBottom.add(TreasureChest1);
        MarketBottom.add(TreasureChest2);
        MarketBottom.add(TreasureChest3);
        MarketBottom.add(TelephoneTerminal1);
        MarketBottom.add(TelephoneTerminal2);
        MarketBottom.add(TelephoneTerminal3);

        bottomdict.put("Scout",3);
        bottomdict.put("Trailblazer",3);
        bottomdict.put("Allrounder",3);
        bottomdict.put("Photographer",3);
        bottomdict.put("TreasureChest",3);
        bottomdict.put("Transmitter",3);



        ExpeditionCard Plane1 = new ExpeditionCard("Plane","White",false,4,4);
        ExpeditionCard Plane2 = new ExpeditionCard("Plane","White",false,4,4);
        ExpeditionCard Plane3 = new ExpeditionCard("Plane","White",false,4,4);
        MarketDeckPlane.add(Plane1);
        MarketDeckPlane.add(Plane2);
        MarketDeckPlane.add(Plane3);

        ExpeditionCard Adventurer1 = new ExpeditionCard("Adventurer","White",true,2,4);
        ExpeditionCard Adventurer2 = new ExpeditionCard("Adventurer","White",true,2,4);
        ExpeditionCard Adventurer3 = new ExpeditionCard("Adventurer","White",true,2,4);
        MarketDeckAdventurer.add(Adventurer1);
        MarketDeckAdventurer.add(Adventurer2);
        MarketDeckAdventurer.add(Adventurer3);

        ExpeditionCard Pioneer1 = new ExpeditionCard("Pioneer","Green",true,5,5);
        ExpeditionCard Pioneer2 = new ExpeditionCard("Pioneer","Green",true,5,5);
        ExpeditionCard Pioneer3 = new ExpeditionCard("Pioneer","Green",true,5,5);
        MarketDeckPioneer.add(Pioneer1);
        MarketDeckPioneer.add(Pioneer2);
        MarketDeckPioneer.add(Pioneer3);


        ExpeditionCard MightyMachete1 = new ExpeditionCard("GiantMachete","Green",false,3,6);
        ExpeditionCard MightyMachete2 = new ExpeditionCard("GiantMachete","Green",false,3,6);
        ExpeditionCard MightyMachete3 = new ExpeditionCard("GiantMachete","Green",false,3,6);
        MarketDeckMighty.add(MightyMachete1);
        MarketDeckMighty.add(MightyMachete2);
        MarketDeckMighty.add(MightyMachete3);


        ExpeditionCard Journalist1 = new ExpeditionCard("Journalist","Yellow",true,3,3);
        ExpeditionCard Journalist2 = new ExpeditionCard("Journalist","Yellow",true,3,3);
        ExpeditionCard Journalist3 = new ExpeditionCard("Journalist","Yellow",true,3,3);
        MarketDeckJournalist.add(Journalist1);
        MarketDeckJournalist.add(Journalist2);
        MarketDeckJournalist.add(Journalist3);

        ExpeditionCard Millionaire1 = new ExpeditionCard("Millionaire","Yellow",true,5,4);
        ExpeditionCard Millionaire2 = new ExpeditionCard("Millionaire","Yellow",true,5,4);
        ExpeditionCard Millionaire3 = new ExpeditionCard("Millionaire","Yellow",true,5,4);
        MarketDeckMillionaire.add(Millionaire1);
        MarketDeckMillionaire.add(Millionaire2);
        MarketDeckMillionaire.add(Millionaire3);

        DrawActionCard Cartographer1 = new DrawActionCard("Cartographer","Purple",true,4,2,false);
        DrawActionCard Cartographer2 = new DrawActionCard("Cartographer","Purple",true,4,2,false);
        DrawActionCard Cartographer3 = new DrawActionCard("Cartographer","Purple",true,4,2,false);
        MarketDeckCartopgrapher.add(Cartographer1);
        MarketDeckCartopgrapher.add(Cartographer2);
        MarketDeckCartopgrapher.add(Cartographer3);

        DrawActionCard Compass1 = new DrawActionCard("Compass","Purple",false,2,3,true);
        DrawActionCard Compass2 = new DrawActionCard("Compass","Purple",false,2,3,true);
        DrawActionCard Compass3 = new DrawActionCard("Compass","Purple",false,2,3,true);
        MarketDeckCompass.add(Compass1);
        MarketDeckCompass.add(Compass2);
        MarketDeckCompass.add(Compass3);

        DrawActionCard TravelDiary1 = new DrawActionCard("TravelDiary","Purple",false,3,3,true);
        DrawActionCard TravelDiary2 = new DrawActionCard("TravelDiary","Purple",false,3,3,true);
        DrawActionCard TravelDiary3 = new DrawActionCard("TravelDiary","Purple",false,3,3,true);
        MarketDeckTravelDiary.add(TravelDiary1);
        MarketDeckTravelDiary.add(TravelDiary2);
        MarketDeckTravelDiary.add(TravelDiary3);

        DrawActionCard Scientist1 = new DrawActionCard("Scientist","Purple",true,4,1,true);
        DrawActionCard Scientist2 = new DrawActionCard("Scientist","Purple",true,4,1,true);
        DrawActionCard Scientist3 = new DrawActionCard("Scientist","Purple",true,4,1,true);
        MarketDeckScientist.add(Scientist1);
        MarketDeckScientist.add(Scientist2);
        MarketDeckScientist.add(Scientist3);

        MoveActionCard Natives1 = new MoveActionCard("Natives","Purple",true,5);
        MoveActionCard Natives2 = new MoveActionCard("Natives","Purple",true,5);
        MoveActionCard Natives3 = new MoveActionCard("Natives","Purple",true,5);
        MarketDeckNatives.add(Natives1);
        MarketDeckNatives.add(Natives2);
        MarketDeckNatives.add(Natives3);

        ExpeditionCard Captain1 = new ExpeditionCard("Captain","Blue",true,2,3);
        ExpeditionCard Captain2 = new ExpeditionCard("Captain","Blue",true,2,3);
        ExpeditionCard Captain3 = new ExpeditionCard("Captain","Blue",true,2,3);
        MarketDeckCaptain.add(Captain1);
        MarketDeckCaptain.add(Captain2);
        MarketDeckCaptain.add(Captain3);

        UpperCards.add(MarketDeckPlane);
        UpperCards.add(MarketDeckAdventurer);
        UpperCards.add(MarketDeckPioneer);
        UpperCards.add(MarketDeckMighty);
        UpperCards.add(MarketDeckJournalist);
        UpperCards.add(MarketDeckMillionaire);
        UpperCards.add(MarketDeckCartopgrapher);
        UpperCards.add(MarketDeckCompass);
        UpperCards.add(MarketDeckTravelDiary);
        UpperCards.add(MarketDeckScientist);
        UpperCards.add(MarketDeckNatives);
        UpperCards.add(MarketDeckCaptain);

        MarketUpper.add(Plane1);
        MarketUpper.add(Plane2);
        MarketUpper.add(Plane3);
        MarketUpper.add(Adventurer1);
        MarketUpper.add(Adventurer2);
        MarketUpper.add(Adventurer3);
        MarketUpper.add(Pioneer1);
        MarketUpper.add(Pioneer2);
        MarketUpper.add(Pioneer3);
        MarketUpper.add(MightyMachete1);
        MarketUpper.add(MightyMachete2);
        MarketUpper.add(MightyMachete3);
        MarketUpper.add(Journalist1);
        MarketUpper.add(Journalist2);
        MarketUpper.add(Journalist3);
        MarketUpper.add(Millionaire1);
        MarketUpper.add(Millionaire2);
        MarketUpper.add(Millionaire3);
        MarketUpper.add(Cartographer1);
        MarketUpper.add(Cartographer2);
        MarketUpper.add(Cartographer3);
        MarketUpper.add(Compass1);
        MarketUpper.add(Compass2);
        MarketUpper.add(Compass3);
        MarketUpper.add(TravelDiary1);
        MarketUpper.add(TravelDiary2);
        MarketUpper.add(TravelDiary3);
        MarketUpper.add(Scientist1);
        MarketUpper.add(Scientist2);
        MarketUpper.add(Scientist3);
        MarketUpper.add(Natives1);
        MarketUpper.add(Natives2);
        MarketUpper.add(Natives3);
        MarketUpper.add(Captain1);
        MarketUpper.add(Captain2);
        MarketUpper.add(Captain3);




        upperdict.put("Plane",3);
        upperdict.put("Adventurer",3);
        upperdict.put("Pioneer",3);
        upperdict.put("GiantMachete",3);
        upperdict.put("Journalist",3);
        upperdict.put("Millionaire",3);
        upperdict.put("Cartographer",3);
        upperdict.put("Compass",3);
        upperdict.put("TravelDiary",3);
        upperdict.put("Scientist",3);
        upperdict.put("Natives",3);
        upperdict.put("Captain",3);


    }

    public static Market getInstance(){
        if(instance == null){
            instance = new Market();
        }
        return instance;
    }
    public int getCurrBottomCards(){
        return currentBottomCards;
    }

    @Transient
    @JsonIgnore
    public boolean isfree() {
        currentBottomCards = BottomCards.size();
        if (currentBottomCards < 6) {
            return true;
        }
        return false;
    }  /** doesnt matter, front end does this... just do the appending of a card if it was before in upper**/

    @Transient
    @JsonIgnore
    public void getCardsfromUpper(List SelectedDeck) {


        BottomCards.add(SelectedDeck);
        UpperCards.remove(SelectedDeck);
        currentBottomCards = currentBottomCards + 1;

    }



    @Transient
    @JsonIgnore
    public void RemoveIfEmpty(List clickedDeck) {
        int LeftonDeckB = clickedDeck.size();
        if (LeftonDeckB <= 0) {
            BottomCards.remove(clickedDeck);
        }

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LinkedHashMap<String, Integer> getBottomdict() {
        return bottomdict;
    }

    public LinkedHashMap<String, Integer> getUpperdict() {
        return upperdict;
    }

    public Card wanted(String cardname) {
        Card wanted = null;
        for (int i = 0; i < MarketBottom.size(); i++) {
            Object obj = MarketBottom.get(i);
            Card card = (Card) obj;
            if (cardname.equals(card.getName())) {
                wanted = card;
                return wanted;

            }
        }

        for (int i = 0; i < MarketUpper.size(); i++) {
            Object obj = MarketUpper.get(i);
            Card card = (Card) obj;
            if (cardname.equals(card.getName())) {
                wanted = card;
                return wanted;

            }
        }

        return null;
    }


}


