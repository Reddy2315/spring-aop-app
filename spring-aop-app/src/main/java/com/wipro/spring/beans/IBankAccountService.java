package com.wipro.spring.beans;

public interface IBankAccountService {

	public String transferAmount(long accountNo,double amount);
	
	public void printAccountInfo();
}
