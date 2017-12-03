package com.java8.lambda;

import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.java8.chapter5.InitializeTraderAndTransaction;
import com.java8.chapter5.Transaction;

public class StreamExample {
	public static void main(String[] args) {
		StreamExample emp = new StreamExample();
		emp.doOperation();
	}

	private void doOperation() {
		List<Transaction> transactions = new InitializeTraderAndTransaction().getTransactionObject();
		Map<Currency, List<Transaction>> transactionsByCurrencies=new HashMap<Currency, List<Transaction>>();
		
		for (Transaction transaction:transactions) {
	//		Currency currency=transaction.getcu
			
			
		}
		
		
	}
}
