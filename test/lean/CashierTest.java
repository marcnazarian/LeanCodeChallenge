package lean;

import static org.junit.Assert.*;

import org.junit.Test;

public class CashierTest {

	@Test
	public void applesCosts100() {
		Cashier cashier = new Cashier();
		assertEquals(100, cashier.scanItemsAndReturnTotalPrice("Apples"));
	}
	
	@Test
	public void cherriesCosts75() {
		Cashier cashier = new Cashier();
		assertEquals(75, cashier.scanItemsAndReturnTotalPrice("Cherries"));
	}
	
	@Test
	public void bananasCosts150() {
		Cashier cashier = new Cashier();
		assertEquals(150, cashier.scanItemsAndReturnTotalPrice("Bananas"));
	}
	
	@Test
	public void twoLotsOfCherriesIs20Discount() {
		Cashier cashier = new Cashier();
		assertEquals(75, cashier.scanItemsAndReturnTotalPrice("Cherries"));
		assertEquals(130, cashier.scanItemsAndReturnTotalPrice("Cherries"));
	}
	
    @Test
    public void iteration_2() {
    	Cashier cashier = new Cashier();
        assertEquals(100, cashier.scanItemsAndReturnTotalPrice("Apples"));
        assertEquals(175, cashier.scanItemsAndReturnTotalPrice("Cherries"));
        assertEquals(230, cashier.scanItemsAndReturnTotalPrice("Cherries"));
    }
    
    @Test
    public void iteration_3_csvFormatAccepted() {
    	Cashier cashier = new Cashier();
        assertEquals(325, cashier.scanItemsAndReturnTotalPrice("Apples,Cherries,Bananas"));
    }
    
    @Test
    public void iteration_3_csvFormatAcceptedCherriesDiscount() {
    	Cashier cashier = new Cashier();
        assertEquals(130, cashier.scanItemsAndReturnTotalPrice("Cherries,Cherries"));
    }
    
}
