package lean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Cashier {

    private int totalPrice;

	public Cashier() {
		totalPrice = 0;
	}

	public void checkout(BufferedReader reader, PrintWriter writer) throws IOException {
    	while (true ) {
    		scanItemAndReturnTotalPrice(reader.readLine());
        	writer.println(totalPrice);
        }
    }

	public int scanItemAndReturnTotalPrice(String item) {
		totalPrice += scanItem(item);
		return totalPrice;
	}

	public int scanItem(String item) {
		int itemPrice = 0;
		if ("Apples".equals(item)) {
			itemPrice = 100;
		} else if ("Cherries".equals(item)) {
			itemPrice = 75;
		} else if ("Bananas".equals(item)) {
			itemPrice = 150;
		}
		return itemPrice;
	}
    
}
