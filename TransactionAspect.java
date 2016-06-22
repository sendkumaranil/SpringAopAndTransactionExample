package org.springaopexamples.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TransactionAspect {

	public void transferTransaction(ProceedingJoinPoint processJp){
		System.out.println("before processing transfer.....");
		
		try {
			
			processJp.proceed();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("after processing transfer ......");
	}
	
	public void depositTransaction(ProceedingJoinPoint processJp,long accountno, double amount){

		System.out.println("before deposit........");
		System.out.println("Parameters passing:accountno="+accountno+" and amount= "+amount);
		try {
			processJp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after deposit......");
	}
}
