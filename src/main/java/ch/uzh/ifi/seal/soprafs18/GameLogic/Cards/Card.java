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

    @Column(unique = false)
    private String name;


    @JsonIgnore
    private Boolean reusable;


    private double Price;

    public Card(){}
    public Card(String name,Boolean reusable,double Price ) {
        this.name =name;
        this.reusable=reusable;
        this.Price=Price;
    }

    public String getName() {
        return name;
    }

    public Boolean getReusable() {
        return reusable;
    }

    public double getPrice() {
        return Price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        Price = price;
    }

}
