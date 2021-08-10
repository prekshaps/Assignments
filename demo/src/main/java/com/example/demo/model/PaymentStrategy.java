package com.example.demo.model;

/**
 * Interface with implemented by Paypal and CreditCardStrategy
 * 
 * @author P7112764
 *
 */
public interface PaymentStrategy {
	/**
	 * 
	 * @param amount accepts the amount as argument
	 * @return
	 */
	public int pay(int amount);

}