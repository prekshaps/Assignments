package com.example.demo.model;

public class ExecuteStrategyOne {
  private PaymentStrategy strategy;
  
  public ExecuteStrategyOne(PaymentStrategy strategy){
      this.strategy = strategy;
   }
  public int executeStrategy(int amount){
      return strategy.pay(amount);
   }

}