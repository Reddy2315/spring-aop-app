package com.wipro.spring.beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class MessagingAspect {

	@Pointcut("execution(* com.wipro.spring.beans.*.transferAmount(long,double))")
	public void sendMsg() {
	}
	
	@Pointcut("execution(* com.wipro.spring.beans.*.printAccountInfo())")
	public void sendInfo() {
	}
	
	//@Around("execution(* com.wipro.spring.beans.*.transferAmount(long,double))")
	@Before("sendMsg()")
	public void sendMessageBeforeTransfer() {
		System.out.println("Amount transferring is happening");
	}

	
	//@After("execution(* com.wipro.spring.beans.*.transferAmount(long,double))")
	@After("sendMsg()")
	public void sendMessageAfterTransfer() {
		System.out.println("Amount transfer completed");
	}
	
	//@Before("sendInfo()")
	public void myAdviceToPrintAccountInfo() {
		System.out.println("myAdviceToPrintAccountInfo()");
	}
	
	@Around("sendInfo()")
	public Object myAdviceToPrintAccountInf(ProceedingJoinPoint pjp) {
		System.out.println("advice before calling printAccountInfo()");
		Object obj=null;
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("advice after calling printAccountInfo()");
		return obj;
	}
	

}
