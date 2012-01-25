package lean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cashier {

    private int totalPrice;
	private boolean alreadyScannedCherries = false;

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
		} else if ("Cherries".equals(item)) {
			if (alreadyScannedCherries) {
				itemPrice = 55;
				alreadyScannedCherries = false;
			} else {
				itemPrice = 75;
				alreadyScannedCherries = true;
			}
		} else if ("Bananas".equals(item)) {
			itemPrice = 150;
		}
		return itemPrice;
	}
    
}
