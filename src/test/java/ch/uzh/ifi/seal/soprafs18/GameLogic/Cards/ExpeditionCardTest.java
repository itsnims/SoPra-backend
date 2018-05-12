package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards;


import org.junit.Assert;
import org.junit.Test;

public class ExpeditionCardTest {


    private ExpeditionCard Tester = new ExpeditionCard("TestName","TestColour",true,1.5,1);


    @Test
    public void getCardStrenghtTest() {
        ExpeditionCard ex = new ExpeditionCard();
        int result = Tester.getCardStrenght();
        Assert.assertEquals(1,result);
    }

    @Test
    public void getName() {
        Tester.setName("Tester");
        String result = Tester.getName();
        Assert.assertEquals("Tester",result);

    }

    @Test
    public void getCardColour() {
        String result = Tester.getCardColour();
        Assert.assertEquals("TestColour",result);
    }

    @Test
    public void getReusable() {
        Tester.setReusable(false);
        Boolean result = Tester.getReusable();
        Assert.assertEquals(false,result);
    }

    @Test
    public void getPrice() {
        Tester.setPrice(2);
        double result = Tester.getPrice();
        Assert.assertEquals(2,result,0);
        System.out.println(result);
    }
}