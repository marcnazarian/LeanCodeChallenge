package lean;

import static org.junit.Assert.*;

import org.junit.Test;

public class CashierTest {

	@Test
	public void applesCosts100() {
		Cashier cashier = new Cashier();
		assertEquals(100, cashier.scanItemAndReturnTotalPrice("Apples"));
	}
	
	@Test
	public void cherriesCosts75() {
		Cashier cashier = new Cashier();
		assertEquals(75, cashier.scanItemAndReturnTotalPrice("Cherries"));
	}
	
	@Test
	public void bananasCosts150() {
		Cashier cashier = new Cashier();
		assertEquals(150, cashier.scanItemAndReturnTotalPrice("Bananas"));
	}
	
	@Test
	public void twoLotsOfCherriesIs20Discount() {
		Cashier cashier = new Cashier();
		assertEquals(75, cashier.scanItemAndReturnTotalPrice("Cherries"));
		assertEquals(130, cashier.scanItemAndReturnTotalPrice("Cherries"));
	}
	
    @Test
    public void iteration_2() {
    	Cashier cashier = new Cashier();
        assertEquals(100, cashier.scanItemAndReturnTotalPrice("Apples"));
        assertEquals(175, cashier.scanItemAndReturnTotalPrice("Cherries"));
        assertEquals(230, cashier.scanItemAndReturnTotalPrice("Cherries"));
    }
    
}
