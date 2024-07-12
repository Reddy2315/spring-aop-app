package com.wipro.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.spring.beans.IBankAccountService;

public class App 
{
    public static void main( String[] args )
    {

    	ApplicationContext ctx=new AnnotationConfigApplicationContext("com.wipro.spring");
    	
    	IBankAccountService bankAccountService = ctx.getBean(IBankAccountService.class);
    	
    	//System.out.println(bankAccountService.transferAmount(123456789, 600));    	
    	
    	bankAccountService.printAccountInfo();
    	
    }
}
