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
		assertEquals(130, cashier.scanItemsAndReturnTotalPrice("Cherries"));
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
        assertEquals(130, cashier.scanItemsAndReturnTotalPrice("Cherries"));
		assertEquals(280, cashier.scanItemsAndReturnTotalPrice("Bananas"));
		assertEquals(280, cashier.scanItemsAndReturnTotalPrice("Bananas"));
    }
    
    @Test
    public void iteration_4() {
    	Cashier cashier = new Cashier();
        assertEquals(75, cashier.scanItemsAndReturnTotalPrice("Cherries"));
        assertEquals(175, cashier.scanItemsAndReturnTotalPrice("Pommes"));
        assertEquals(230, cashier.scanItemsAndReturnTotalPrice("Cherries"));
		assertEquals(380, cashier.scanItemsAndReturnTotalPrice("Bananas"));
		assertEquals(380, cashier.scanItemsAndReturnTotalPrice("Bananas"));
		assertEquals(480, cashier.scanItemsAndReturnTotalPrice("Apples"));
    }
    
    @Test
    public void iteration_5() {
    	Cashier cashier = new Cashier();
        assertEquals(100, cashier.scanItemsAndReturnTotalPrice("Mele"));
        assertEquals(200, cashier.scanItemsAndReturnTotalPrice("Pommes"));
        assertEquals(300, cashier.scanItemsAndReturnTotalPrice("Pommes"));
		assertEquals(400, cashier.scanItemsAndReturnTotalPrice("Apples"));
		assertEquals(400, cashier.scanItemsAndReturnTotalPrice("Pommes"));
		assertEquals(450, cashier.scanItemsAndReturnTotalPrice("Mele"));
		assertEquals(525, cashier.scanItemsAndReturnTotalPrice("Cherries"));
        assertEquals(580, cashier.scanItemsAndReturnTotalPrice("Cherries"));
    }
    
}
