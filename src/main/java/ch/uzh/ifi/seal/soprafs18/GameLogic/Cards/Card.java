package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name="type")
public abstract class Card {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Transient
    @JsonIgnore
    private String cardColour;
    @Transient
    @JsonIgnore
    private Boolean reusable;
    @Transient
    @JsonIgnore
    private double Price;

    public Card(){}
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
