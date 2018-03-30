package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards;

public abstract class ActionCard extends Card {

    public ActionCard(String name,String cardColour,Boolean reusable, Integer Price){
        super(name,cardColour,reusable,Price);
    }
    public abstract void doSpecialFunction();

}
