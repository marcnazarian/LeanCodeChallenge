package lean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cashier {

    private int totalPrice;
    
	private int nbPommes = 0;
	private int nbMele = 0;
	private int nbCherries = 0;
	private int nbBananas = 0;

	public Cashier() {
		totalPrice = 0;
	}

	public void checkout(BufferedReader reader, PrintWriter writer) throws IOException {
    	while (true ) {
    		scanItemsAndReturnTotalPrice(reader.readLine());
        	writer.println(totalPrice);
        }
    }

	public int scanItemsAndReturnTotalPrice(String input) {
		StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
		while (stringTokenizer.hasMoreTokens()) {
			totalPrice += scanItem(stringTokenizer.nextToken());
		}
		return totalPrice;
	}

	public int scanItem(String item) {
		int itemPrice = 0;
		if ("Apples".equals(item)) {
			itemPrice = 100;
		} else if ("Pommes".equals(item)) {
			nbPommes++;
			if (isThirdPomme()) {
				itemPrice = 0;
			} else {
				itemPrice = 100;
			}
		} else if ("Mele".equals(item)) {
			nbMele++;
			if (isSecondMele()) {
				itemPrice = 50;
			} else {
				itemPrice = 100;
			}
		} else if ("Cherries".equals(item)) {
			nbCherries++;
			if (isSecondCherries()) {
				itemPrice = 55;
			} else {
				itemPrice = 75;
			}
		} else if ("Bananas".equals(item)) {
			nbBananas++;
			if (isSecondBananas()) {
				itemPrice = 0;
			} else {
				itemPrice = 150;
			}
		}
		return itemPrice;
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
