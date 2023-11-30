package unitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import ticket.Tickets;

public class UnitTest {
    @Test
    public void ticketsTest_infant_priceisZero() {
        Tickets infant = new Tickets(1,1000);
        double result = infant.getPrice();
        Assert.assertEquals(result,0.0);
    }
    @Test
    public void ticketsTest_child_priceIsZero() {
        Tickets child = new Tickets(3, 1000);
        double result = child.getPrice();
        Assert.assertEquals(result, 500);
    }
    @Test
    public void ticketsTest_Adult_priceIsZero() {
        Tickets adult = new Tickets(50, 1000);
        double result = adult.getPrice();
        Assert.assertEquals(result, 1000);
    }
    @Test
    public void ticketsTest_Senior_priceIsZero() {
        Tickets senior = new Tickets(68, 1000);
        double result = senior.getPrice();
        Assert.assertEquals(result, 800);
    }
}
