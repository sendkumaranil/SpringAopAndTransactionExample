package org.springaopexamples.aop;

public class LoggingAspect {
	
	public void logBefore(){
		System.out.println("Hi I am inside logBefore method");
		System.out.println("User is accessing Bank Operations...");
	}
	
	public void logAfter(){
		System.out.println("Hi I am inside logAfter method");
	}
	
	public void logBeforeWithPointcutInfo(JoinPoint joinpoint){
		System.out.println("Calling..["+joinpoint.getTarget().getClass()+"]:["+joinpoint.getSignature()+"]");
	}

}
