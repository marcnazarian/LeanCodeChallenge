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
	public void twoLotsOfCherriesIs30Discount() {
		Cashier cashier = new Cashier();
		assertEquals(75, cashier.scanItemsAndReturnTotalPrice("Cherries"));
		assertEquals(120, cashier.scanItemsAndReturnTotalPrice("Cherries"));
	}
	
    @Test
    public void iteration_3_csvFormatAccepted() {
    	Cashier cashier = new Cashier();
        assertEquals(325, cashier.scanItemsAndReturnTotalPrice("Apples,Cherries,Bananas"));
    }
    
    @Test
    public void iteration_3_csvFormatAcceptedCherriesDiscount() {
    	Cashier cashier = new Cashier();
        assertEquals(120, cashier.scanItemsAndReturnTotalPrice("Cherries,Cherries"));
    }
    
    @Test
	public void secondBanansIsFree() {
		Cashier cashier = new Cashier();
		assertEquals(150, cashier.scanItemsAndReturnTotalPrice("Bananas"));
		assertEquals(150, cashier.scanItemsAndReturnTotalPrice("Bananas"));
	}
    
    @Test
    public void iteration_3a() {
    	Cashier cashier = new Cashier();
        assertEquals(75, cashier.scanItemsAndReturnTotalPrice("Cherries"));
        assertEquals(120, cashier.scanItemsAndReturnTotalPrice("Cherries"));
		assertEquals(270, cashier.scanItemsAndReturnTotalPrice("Bananas"));
		assertEquals(270, cashier.scanItemsAndReturnTotalPrice("Bananas"));
    }
    
}
