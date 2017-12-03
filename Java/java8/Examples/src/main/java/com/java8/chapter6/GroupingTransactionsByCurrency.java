package com.java8.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;

public class GroupingTransactionsByCurrency {
	public static void main(String[] args) {
		
		System.out.println(new Date().getTime());
		Map<Currency, List<Transaction>> transactionByCurrencies1=groupTransactionWithoutStreams(intializeTransactionObject());
		System.out.println(new Date().getTime());
		Map<Currency, List<Transaction>> transactionByCurrencies2=groupTransactionWithStreams(intializeTransactionObject());
		System.out.println(new Date().getTime());

	}

	private static Map<Currency, List<Transaction>> groupTransactionWithoutStreams(
			List<Transaction> transactions) {
			Map<Currency, List<Transaction>> transactionsByCurrencies=new HashMap<Currency, List<Transaction>>();
			
			for(Transaction transaction : transactions){
				Currency  currency=transaction.getCurrency();
	            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
	            
					 if (transactionsForCurrency == null) {
						 transactionsForCurrency = new ArrayList<Transaction>();
		                transactionsByCurrencies.put(currency, transactionsForCurrency);
		            }
				transactionsForCurrency.add(transaction);
				
			}
			
			return  transactionsByCurrencies;
	}

	
	private static Map<Currency, List<Transaction>> groupTransactionWithStreams(
			List<Transaction> transactions) {

		   Map<Currency, List<Transaction>> transactionsByCurrencies=transactions.stream()
				   														.collect(groupingBy(Transaction::getCurrency));
		
			return transactionsByCurrencies;
	}
	
	private static List<Transaction> intializeTransactionObject() {
		List<Transaction> transactions = Arrays.asList(new Transaction(
				Currency.EUR, 1500.0), new Transaction(Currency.USD, 2300.0),
				new Transaction(Currency.GBP, 9900.0), new Transaction(
						Currency.EUR, 1100.0), new Transaction(Currency.JPY,
						7800.0), new Transaction(Currency.CHF, 6700.0),
				new Transaction(Currency.EUR, 5600.0), new Transaction(
						Currency.USD, 4500.0), new Transaction(Currency.CHF,
						3400.0), new Transaction(Currency.GBP, 3200.0),
				new Transaction(Currency.USD, 4600.0), new Transaction(
						Currency.JPY, 5700.0), new Transaction(Currency.EUR,
						6800.0));
		return transactions;
	}


 public static class Transaction {

	private  Currency currency;
	private double value;

	
	public Transaction(Currency currency, double value) {
		this.currency=currency;
		this.value=value;
	}


	public Currency getCurrency() {
		return currency;
	}


	public void setCurrency(Currency currency) {
		this.currency = currency;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	
	public String toString() {
		
		return "{" +
				"currency: "+this.currency+", " +
				"value:" + this.value +"}";
	}
	
}

public static enum Currency {
	  EUR, USD, JPY, GBP, CHF

}
}
