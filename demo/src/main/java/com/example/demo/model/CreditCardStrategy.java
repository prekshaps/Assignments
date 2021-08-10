package com.example.demo.model;

/**
 * class Implements the PaymentStrategy and override the unIplemented method pay
 * @author P7112764
 *
 */

public class CreditCardStrategy implements PaymentStrategy {

	/**
	 * @return return the amount
	 * @param accepts the amount as parameter
	 */
	@Override
	public int pay(int amount) {
		
		return amount;
		
	}
	

}
