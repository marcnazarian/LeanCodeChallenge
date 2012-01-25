package lean;

import static org.junit.Assert.*;

import org.junit.Test;

public class CashierTest {

    @Test
    public void iteration_1() {
    	Cashier cashier = new Cashier();
        assertEquals(100, cashier.scanItemAndReturnTotalPrice("Apples"));
        assertEquals(175, cashier.scanItemAndReturnTotalPrice("Cherries"));
        assertEquals(250, cashier.scanItemAndReturnTotalPrice("Cherries"));
    }
    
    @Test
    public void iteration_1_withBananas() {
    	Cashier cashier = new Cashier();
        assertEquals(150, cashier.scanItemAndReturnTotalPrice("Bananas"));
    }

}
