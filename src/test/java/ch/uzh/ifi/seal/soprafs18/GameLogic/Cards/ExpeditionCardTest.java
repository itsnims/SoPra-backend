package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards;


import org.junit.Assert;
import org.junit.Test;

public class ExpeditionCardTest {


    private ExpeditionCard Tester = new ExpeditionCard("TestName","TestColour",true,1.5,1);


    @Test
    public void getCardStrenghtTest() {
        int result = Tester.getCardStrenght();
        Assert.assertEquals(1,result);
    }

    @Test
    public void getName() {
        String result = Tester.getName();
        Assert.assertEquals("TestName",result);

    }

    @Test
    public void getCardColour() {
        String result = Tester.getCardColour();
        Assert.assertEquals("TestColour",result);
    }

    @Test
    public void getReusable() {
        Boolean result = Tester.getReusable();
        Assert.assertEquals(true,result);
    }

    @Test
    public void getPrice() {
        double result = Tester.getPrice();
        Assert.assertEquals(1.5,result,0);
        System.out.println(result);
    }
}