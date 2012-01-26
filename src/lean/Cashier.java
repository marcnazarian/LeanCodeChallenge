package lean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Cashier {

	private static final String BANANAS = "Bananas";
	private static final String CHERRIES = "Cherries";
	private static final String MELE = "Mele";
	private static final String POMMES = "Pommes";
	private static final String APPLES = "Apples";
	
	private static final String CSV_ITEMS_SEPARATOR = ",";
	
	private static final int PRICE_FOR_CHERRIES = 75;
	private static final int PRICE_FOR_APPLES   = 100;
	private static final int PRICE_FOR_POMMES   = 100;
	private static final int PRICE_FOR_MELE     = 100;
	private static final int PRICE_FOR_BANANAS  = 150;

	private static final int DISCOUNT_FOR_SECOND_CHERRIES = 20;
	private static final int DISCOUNT_FOR_SECOND_MELE = 50;
	private static final int DISCOUNT_FOR_FOURTH_APPLE_FAMILY = 100;
	private static final int DISCOUNT_FOR_FIFTH_PIECE_OF_FRUIT = 200;
	
	private int totalPrice;

	private Map<String, Integer> basketContent = new HashMap<String, Integer>();
	
	public Cashier() {
		totalPrice = 0;
		initBasketContent();
	}

	private void initBasketContent() {
		basketContent.put(APPLES, 0);
		basketContent.put(POMMES, 0);
		basketContent.put(MELE, 0);
		basketContent.put(CHERRIES, 0);
		basketContent.put(BANANAS, 0);
	}

	public void checkout(BufferedReader reader, PrintWriter writer) throws IOException {
		while (true) {
			writer.println(scanItemsAndReturnTotalPrice(reader.readLine()));
		}
	}

	public int scanItemsAndReturnTotalPrice(String input) {
		StringTokenizer stringTokenizer = new StringTokenizer(input, CSV_ITEMS_SEPARATOR);
		while (stringTokenizer.hasMoreTokens()) {
			String currentItem = stringTokenizer.nextToken();
			scanItem(currentItem);
		}
		return totalPrice;
	}

	private void scanItem(String currentItem) {
		if (isKnownItem(currentItem)) {
			addItemToBasket(currentItem);
			totalPrice += getPriceForItem(currentItem);
			applyDiscountOffTheBill(currentItem);
		}
	}
	
	private boolean isKnownItem(String currentItem) {
		return basketContent.keySet().contains(currentItem);
	}
	
	private void addItemToBasket(String item) {
		basketContent.put(item, basketContent.get(item) + 1);
	}

	private int getPriceForItem(String item) {
		int itemPrice = 0;
		if (APPLES.equals(item)) {
			itemPrice = getPriceForApples();
		} else if (POMMES.equals(item)) {
			itemPrice = getPriceForPommes();
		} else if (MELE.equals(item)) {
			itemPrice = getPriceForMele();
		} else if (CHERRIES.equals(item)) {
			itemPrice = getPriceforCherries();
		} else if (BANANAS.equals(item)) {
			itemPrice = getPriceForBananas();
		}
		return itemPrice;
	}

	private int getPriceForApples() {
		return PRICE_FOR_APPLES;
	}
	
	private int getPriceForPommes() {
		int itemPrice = PRICE_FOR_POMMES;
		if (isThirdPomme()) {
			itemPrice = 0;
		}
		return itemPrice;
	}
	
	private int getPriceForMele() {
		int itemPrice = PRICE_FOR_MELE;
		if (isSecondMele()) {
			itemPrice -= DISCOUNT_FOR_SECOND_MELE;
		}
		return itemPrice;
	}
	
	private int getPriceforCherries() {
		int itemPrice = PRICE_FOR_CHERRIES;
		if (isSecondCherries()) {
			itemPrice -= DISCOUNT_FOR_SECOND_CHERRIES;
		}
		return itemPrice;
	}

	private int getPriceForBananas() {
		int itemPrice = PRICE_FOR_BANANAS;
		if (isSecondBananas()) {
			itemPrice = 0;
		}
		return itemPrice;
	}
	
	private void applyDiscountOffTheBill(String currentItem) {
		if (isFifthPieceOfFruit()) {
			totalPrice -= DISCOUNT_FOR_FIFTH_PIECE_OF_FRUIT;
		}
		if (isAppleFamily(currentItem) && isFourthApple()) {
			totalPrice -= DISCOUNT_FOR_FOURTH_APPLE_FAMILY;
		}
	}

	private boolean isFifthPieceOfFruit() {
		int nbPieceOfFruit = getNbPieceOfFruit();
		return nbPieceOfFruit != 0 && nbPieceOfFruit % 5 == 0;
	}
	
	private int getNbPieceOfFruit() {
		int nbPieceOfFruit = 0;
		for (int value : basketContent.values()) {
		    nbPieceOfFruit += value;
		}
		return nbPieceOfFruit;
	}

	private boolean isAppleFamily(String currentItem) {
		return APPLES.equals(currentItem) || POMMES.equals(currentItem) || MELE.equals(currentItem);
	}
	

	private int getNbApplesInBasket() {
		return basketContent.get(APPLES) + basketContent.get(POMMES) + basketContent.get(MELE);
	}
	
	private boolean isFourthApple() {
		return isNumberMultipleOf(getNbApplesInBasket(), 4);
	}

	private boolean isSecondCherries() {
		return isFruitMultipleOf(CHERRIES, 2);
	}

	private boolean isSecondBananas() {
		return isFruitMultipleOf(BANANAS, 2);
	}

	private boolean isSecondMele() {
		return isFruitMultipleOf(MELE, 2);
	}

	private boolean isThirdPomme() {
		return isFruitMultipleOf(POMMES, 3);
	}
	
	private boolean isFruitMultipleOf(String fruit, int multipleOf) {
		return isNumberMultipleOf(basketContent.get(fruit), multipleOf);
	}

	private boolean isNumberMultipleOf(int number, int multipleOf) {
		return number % multipleOf == 0;
	}
	
}
