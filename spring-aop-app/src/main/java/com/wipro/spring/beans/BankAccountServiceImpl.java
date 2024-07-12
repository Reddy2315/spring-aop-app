package com.wipro.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class BankAccountServiceImpl implements IBankAccountService {

	private String accountNumbers[]= {"123456789","987654321","1122334455","6677889911"};
	
	public String transferAmount(long accountNo, double amount) {

		for(String accountNumber:accountNumbers) {
			long acnt=Long.parseLong(accountNumber);
			if(acnt==accountNo && amount>500) {
				return "Amount "+amount+" is transferred to the account:"+accountNo;
			}
		}
		
		return "Amount "+amount+" is not transferred as accountNo is invalid";
	}

	public void printAccountInfo() {
	
		
		for(String account:accountNumbers) {
			
			System.out.println("Account is:"+account);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
