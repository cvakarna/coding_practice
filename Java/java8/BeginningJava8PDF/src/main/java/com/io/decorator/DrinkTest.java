package com.io.decorator;

import org.apache.log4j.Logger;

import com.io.GetFiles;

public class DrinkTest {
	private Logger log = Logger.getLogger(DrinkTest.class);

	public static void main(String[] args) {
		DrinkTest example = new DrinkTest();
		example.demo();
	}

	private void demo() {
		Drink d1 = new Whiskey();
		printReceipt(d1);

		Drink d2 = new Honey(new Whiskey());
		printReceipt(d2);
		
		Drink d3 = new Spices(new Vodka());
		printReceipt(d3);
		
		Drink d4 = new Spices(new Honey(new Honey(new Rum())));
		printReceipt(d4);
		
	}

	public  void printReceipt(Drink drink) {
		String name = drink.getName();
		double price = drink.getPrice();
		log.debug(name + " - $" + price);
	}

}
