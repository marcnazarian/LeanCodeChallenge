package lean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Cashier {

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
		basketContent.put("Apples", 0);
		basketContent.put("Pommes", 0);
		basketContent.put("Mele", 0);
		basketContent.put("Cherries", 0);
		basketContent.put("Bananas", 0);
	}

	public void checkout(BufferedReader reader, PrintWriter writer) throws IOException {
		while (true) {
			writer.println(scanItemsAndReturnTotalPrice(reader.readLine()));
		}
	}

	public int scanItemsAndReturnTotalPrice(String input) {
		StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
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
		if ("Apples".equals(item)) {
			itemPrice = getPriceForApples();
		} else if ("Pommes".equals(item)) {
			itemPrice = getPriceForPommes();
		} else if ("Mele".equals(item)) {
			itemPrice = getPriceForMele();
		} else if ("Cherries".equals(item)) {
			itemPrice = getPriceforCherries();
		} else if ("Bananas".equals(item)) {
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
		return "Apples".equals(currentItem) || "Pommes".equals(currentItem) || "Mele".equals(currentItem);
	}
	

	private int getNbApplesInBasket() {
		return basketContent.get("Apples") + basketContent.get("Pommes") + basketContent.get("Mele");
	}
	
	private boolean isFourthApple() {
		return isNumberMultipleOf(getNbApplesInBasket(), 4);
	}

	private boolean isSecondCherries() {
		return isFruitMultipleOf("Cherries", 2);
	}

	private boolean isSecondBananas() {
		return isFruitMultipleOf("Bananas", 2);
	}

	private boolean isSecondMele() {
		return isFruitMultipleOf("Mele", 2);
	}

	private boolean isThirdPomme() {
		return isFruitMultipleOf("Pommes", 3);
	}
	
	private boolean isFruitMultipleOf(String fruit, int multipleOf) {
		return isNumberMultipleOf(basketContent.get(fruit), multipleOf);
	}

	private boolean isNumberMultipleOf(int number, int multipleOf) {
		return number % multipleOf == 0;
	}
	
}
