package com.example.demo.model;

/**
 * class acts as a context to paymentStrategy class
 * @author P7112764
 *
 */
public class ExecuteStrategyOne {
  private PaymentStrategy strategy;
  
  public ExecuteStrategyOne(PaymentStrategy strategy){
      this.strategy = strategy;
   }
  public int executeStrategy(int amount){
      return strategy.pay(amount);
   }

}