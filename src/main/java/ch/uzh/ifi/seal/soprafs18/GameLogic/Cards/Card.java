package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards;

public abstract class Card {
    private String name;
    private String cardColour;
    private Boolean reusable;
    private double Price;

    public Card(String name,String cardColour,Boolean reusable,double Price ) {
        this.name =name;
        this.cardColour=cardColour;
        this.reusable=reusable;
        this.Price=Price;
    }

    public String getName() {
        return name;
    }

    public String getCardColour() {
        return cardColour;
    }

    public Boolean getReusable() {
        return reusable;
    }

    public double getPrice() {
        return Price;
    }
}
