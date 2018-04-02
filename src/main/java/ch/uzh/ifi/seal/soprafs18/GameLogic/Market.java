package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.DrawActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MoveActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;


import java.util.ArrayList;
import java.util.List;

public class Market {
    public ArrayList<List> BottomCards = new ArrayList<>(6);
    public List<List> UpperCards = new ArrayList<List>(12);
    private Boolean isfreeBottomPlace;
    private Integer currentBottomCards;


    public Market(){
        List<Card> MarketDeckScout = new ArrayList<>(3);
        List<Card> MarketDeckExplorer = new ArrayList<>(3);
        List<Card> MarketDeckAllrounder = new ArrayList<>(3);
        List<Card> MarketDeckPhotgrapher = new ArrayList<>(3);
        List<Card> MarketDeckTreasureChest = new ArrayList<>(3);
        List<Card> MarketDeckTelephone = new ArrayList<>(3);
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
        MarketDeckScout.add(Scout1);
        MarketDeckScout.add(Scout2);
        MarketDeckScout.add(Scout3);

        ExpeditionCard Explorer1 = new ExpeditionCard("Explorer","Green",true,3,3);
        ExpeditionCard Explorer2 = new ExpeditionCard("Explorer","Green",true,3,3);
        ExpeditionCard Explorer3 = new ExpeditionCard("Explorer","Green",true,3,3);
        MarketDeckExplorer.add(Explorer1);
        MarketDeckExplorer.add(Explorer2);
        MarketDeckExplorer.add(Explorer3);

        ExpeditionCard AllRounder1 = new ExpeditionCard("Allrounder","White",true,2,1);
        ExpeditionCard AllRounder2 = new ExpeditionCard("Allrounder","White",true,2,1);
        ExpeditionCard AllRounder3 = new ExpeditionCard("Allrounder","White",true,2,1);
        MarketDeckAllrounder.add(AllRounder1);
        MarketDeckAllrounder.add(AllRounder2);
        MarketDeckAllrounder.add(AllRounder3);

        ExpeditionCard Photographer1 = new ExpeditionCard("Photgrapher","Yellow",true,2,2);
        ExpeditionCard Photographer2 = new ExpeditionCard("Photgrapher","Yellow",true,2,2);
        ExpeditionCard Photographer3 = new ExpeditionCard("Photgrapher","Yellow",true,2,2);
        MarketDeckPhotgrapher.add(Photographer1);
        MarketDeckPhotgrapher.add(Photographer2);
        MarketDeckPhotgrapher.add(Photographer3);

        ExpeditionCard TreasureChest1 = new ExpeditionCard("Treasure Chest","Yellow",false,3,4);
        ExpeditionCard TreasureChest2 = new ExpeditionCard("Treasure Chest","Yellow",false,3,4);
        ExpeditionCard TreasureChest3 = new ExpeditionCard("Treasure Chest","Yellow",false,3,4);
        MarketDeckTreasureChest.add(TreasureChest1);
        MarketDeckTreasureChest.add(TreasureChest2);
        MarketDeckTreasureChest.add(TreasureChest3);

        MoveActionCard TelephoneTerminal1 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        MoveActionCard TelephoneTerminal2 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        MoveActionCard TelephoneTerminal3 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        MarketDeckTelephone.add(TelephoneTerminal1);
        MarketDeckTelephone.add(TelephoneTerminal2);
        MarketDeckTelephone.add(TelephoneTerminal3);

        BottomCards.add(MarketDeckScout);
        BottomCards.add(MarketDeckExplorer);
        BottomCards.add(MarketDeckAllrounder);
        BottomCards.add(MarketDeckPhotgrapher);
        BottomCards.add(MarketDeckTreasureChest);
        BottomCards.add(MarketDeckTelephone);

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


        ExpeditionCard MightyMachete1 = new ExpeditionCard("Mighty Machete","Green",false,3,6);
        ExpeditionCard MightyMachete2 = new ExpeditionCard("Mighty Machete","Green",false,3,6);
        ExpeditionCard MightyMachete3 = new ExpeditionCard("Mighty Machete","Green",false,3,6);
        MarketDeckMighty.add(MightyMachete1);
        MarketDeckMighty.add(MightyMachete2);
        MarketDeckMighty.add(MightyMachete3);


        ExpeditionCard Journalist1 = new ExpeditionCard("Journalist","Yellow",true,3,3);
        ExpeditionCard Journalist2 = new ExpeditionCard("Journalist","Yellow",true,3,3);
        ExpeditionCard Journalist3 = new ExpeditionCard("Journalist","Yellow",true,3,3);
        MarketDeckJournalist.add(Journalist1);
        MarketDeckJournalist.add(Journalist2);
        MarketDeckJournalist.add(Journalist3);

        ExpeditionCard Milionaire1 = new ExpeditionCard("Milionaire","Yellow",true,5,4);
        ExpeditionCard Milionaire2 = new ExpeditionCard("Milionaire","Yellow",true,5,4);
        ExpeditionCard Milionaire3 = new ExpeditionCard("Milionaire","Yellow",true,5,4);
        MarketDeckMillionaire.add(Milionaire1);
        MarketDeckMillionaire.add(Milionaire2);
        MarketDeckMillionaire.add(Milionaire3);

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

        DrawActionCard TravelDiary1 = new DrawActionCard("Travel Diary","Purple",false,3,3,true);
        DrawActionCard TravelDiary2 = new DrawActionCard("Travel Diary","Purple",false,3,3,true);
        DrawActionCard TravelDiary3 = new DrawActionCard("Travel Diary","Purple",false,3,3,true);
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


    }
    public void isfree() {
        currentBottomCards = BottomCards.size();
        if (currentBottomCards < 6) {
            isfreeBottomPlace = true;
        }
    }


    public void getCardfromUpper() {

        if (isfreeBottomPlace) {
            BottomCards.add(UpperCards.get(0));
            UpperCards.remove(0);
            currentBottomCards = currentBottomCards + 1;
        }
    }

    public double getCardPrice () {
        List<Card>  BottomDeck = BottomCards.get(0);
        Card DeckCard = BottomDeck.get(0);
        double BottomDeckPrice = DeckCard.getPrice();
        return BottomDeckPrice;
    }

    public Integer LeftonDeckBottom() {
        List<Card> DeckB = BottomCards.get(0);
        int LeftonDeckB = DeckB.size();
        if (LeftonDeckB <= 0){
            BottomCards.remove(0);
        }
        return LeftonDeckB;
    }


    public Integer LeftonDeckUpper() {
        List<Card> DeckU = UpperCards.get(0);
        int LeftonDeckU = DeckU.size();
        if (LeftonDeckU <= 0) {
            UpperCards.remove(0);
        }
        return LeftonDeckU;
    }

}


