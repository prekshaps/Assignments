package com.example.demo.model;

/**
 * class PaypalStrategy implements the PaymentStrategy and override the Unimplemented method
 * @author P7112764
 *
 */
public class PaypalStrategy implements PaymentStrategy {
	/**
	 * @return return the amount
	 * @param accepts the amount as parameter
	 */
	@Override
	public int pay(int amount) {
		
		return amount;
	

	}
	

}
