package com.io.decorator;

public class DrinkDecorator extends Drink {

	protected Drink drink;

	@Override
	public String getName() {
		return drink.getName() + ", " + this.name;
	}

	@Override
	public double getPrice() {

		return drink.getPrice() + this.price;
	}

	public Drink getDrink() {
		return drink;
	}
}
