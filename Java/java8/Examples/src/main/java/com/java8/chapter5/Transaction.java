package com.java8.chapter5;

import java.util.Currency;

public class Transaction {

	private Trader trader;
	private  int year;
	private int value;

	public Transaction(Trader trader, int year, int value) {
		this.trader=trader;
		this.year=year;
		this.value=value;
				
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		
		return "{" + this.trader + ", " +
				"year: "+this.year+", " +
				"value:" + this.value +"}";
	}
	
}

