package com.example.demo.model;



public class CreditCardStrategy implements PaymentStrategy {

	@Override
	public int pay(int amount) {
		
		return amount;
		
	}
	

}
