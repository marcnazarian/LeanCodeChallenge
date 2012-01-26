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
    public void csvFormatIsAccepted() {
    	Cashier cashier = new Cashier();
        assertEquals(325, cashier.scanItemsAndReturnTotalPrice("Apples,Cherries,Bananas"));
    }
    
    @Test
	public void secondBananasIsFree() {
		Cashier cashier = new Cashier();
		assertEquals(150, cashier.scanItemsAndReturnTotalPrice("Bananas"));
		assertEquals(150, cashier.scanItemsAndReturnTotalPrice("Bananas"));
	}
    
    @Test
    public void pommesIsAlsoAccepted() {
    	Cashier cashier = new Cashier();
        assertEquals(75, cashier.scanItemsAndReturnTotalPrice("Cherries"));
        assertEquals(175, cashier.scanItemsAndReturnTotalPrice("Pommes"));
        assertEquals(230, cashier.scanItemsAndReturnTotalPrice("Cherries"));
		assertEquals(380, cashier.scanItemsAndReturnTotalPrice("Bananas"));
		assertEquals(180, cashier.scanItemsAndReturnTotalPrice("Bananas"));
		assertEquals(280, cashier.scanItemsAndReturnTotalPrice("Apples"));
    }
    
    @Test
    public void discountOnThirdPommesAndSecondMela() {
    	Cashier cashier = new Cashier();
        assertEquals(430, cashier.scanItemsAndReturnTotalPrice("Mele,Pommes,Pommes,Apples,Pommes,Mele,Cherries,Cherries,Bananas"));
    }
    
    @Test
    public void extraDiscountForFourthApplesAndFifthFruit() {
    	Cashier cashier = new Cashier();
        assertEquals(250, cashier.scanItemsAndReturnTotalPrice("Mele,Pommes,Pommes,Mele"));
        assertEquals(200, cashier.scanItemsAndReturnTotalPrice("Bananas"));
    }
    
    @Test
    public void extraDiscountForFourthApplesAndFifthFruitApplesOnly() {
    	Cashier cashier = new Cashier();
    	assertEquals(150, cashier.scanItemsAndReturnTotalPrice("Mele,Pommes,Pommes,Apples,Mele"));
    }
}
