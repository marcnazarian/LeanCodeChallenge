package lean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cashier {

	private static final int PRICE_FOR_CHERRIES = 75;
	private static final int PRICE_FOR_APPLES   = 100;
	private static final int PRICE_FOR_POMMES   = 100;
	private static final int PRICE_FOR_MELE     = 100;
	private static final int PRICE_FOR_BANANAS  = 150;

	private static final int DISCOUNT_FOR_SECOND_CHERRIES = 20;
	private static final int DISCOUNT_FOR_SECOND_MELE = 50;
	
	private int totalPrice;

	private int nbPommes = 0;
	private int nbMele = 0;
	private int nbCherries = 0;
	private int nbBananas = 0;
	private int nbApples = 0;
	private int nbPieceOfFruits = 0;

	public Cashier() {
		totalPrice = 0;
	}

	public void checkout(BufferedReader reader, PrintWriter writer)
			throws IOException {
		while (true) {
			scanItemsAndReturnTotalPrice(reader.readLine());
			writer.println(totalPrice);
		}
	}

	public int scanItemsAndReturnTotalPrice(String input) {
		StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
		while (stringTokenizer.hasMoreTokens()) {
			totalPrice += scanItem(stringTokenizer.nextToken());
			if (isFifthPieceOfFruit()) {
				totalPrice -= 200;
			}
		}
		return totalPrice;
	}

	public int scanItem(String item) {
		int itemPrice = 0;
		if ("Apples".equals(item)) {
			nbPieceOfFruits++;
			nbApples++;
			itemPrice = PRICE_FOR_APPLES;
			if (isFourthApple()) {
				itemPrice -= 100;
			}
		} else if ("Pommes".equals(item)) {
			nbPieceOfFruits++;
			nbPommes++;
			nbApples ++;
			itemPrice = PRICE_FOR_POMMES;
			if (isThirdPomme()) {
				itemPrice = 0;
			}
			if (isFourthApple()) {
				itemPrice -= 100;
			}
		} else if ("Mele".equals(item)) {
			nbPieceOfFruits++;
			nbMele++;
			nbApples++;
			itemPrice = PRICE_FOR_MELE;
			if (isSecondMele()) {
				itemPrice = PRICE_FOR_MELE - DISCOUNT_FOR_SECOND_MELE;
			}
			if (isFourthApple()) {
				itemPrice -= 100;
			}
		} else if ("Cherries".equals(item)) {
			nbPieceOfFruits++;
			nbCherries++;
			itemPrice = PRICE_FOR_CHERRIES;
			if (isSecondCherries()) {
				itemPrice = PRICE_FOR_CHERRIES - DISCOUNT_FOR_SECOND_CHERRIES;
			}
		} else if ("Bananas".equals(item)) {
			nbPieceOfFruits++;
			nbBananas++;
			itemPrice = PRICE_FOR_BANANAS;
			if (isSecondBananas()) {
				itemPrice = 0;
			}
		}
		return itemPrice;
	}

	private boolean isFifthPieceOfFruit() {
		return nbPieceOfFruits != 0 && nbPieceOfFruits % 5 == 0;
	}
	
	private boolean isFourthApple() {
		return nbApples != 0 && nbApples % 4 == 0;
	}

	private boolean isSecondCherries() {
		return nbCherries % 2 == 0;
	}

	private boolean isSecondBananas() {
		return nbBananas % 2 == 0;
	}

	private boolean isSecondMele() {
		return nbMele % 2 == 0;
	}

	private boolean isThirdPomme() {
		return nbPommes % 3 == 0;
	}

}
