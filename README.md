# SpringAopAndTransactionExample
Spring Aspect Oriented Programming and Transaction Management
<hr>
Spring AOP
----------
Spring Aspect Oriented Programming (AOP) provided solution of cross-cutting concern.
<p>The major advantage is here you actually splitted aspect and actual business logic (target) so our aspect functionality does not impact on actual business logic class.</p>
<p>The aspect is configured in spring xml class so whenever client does not want any aspect we can easily removed.</p>

<p>Cross-cutting problem:</p>
<ul>
	<li>Security</li>
	<li>Logging</li>
	<li>Transaction</li>
</ul>

<b>Basic Term used in AOP:</b><br>
<ul>
	<li><b>Advice:</b>This is the action which takes places of an aspect.</li>
	<li><b>Joinpoint:</b>This is point in execution of application where an aspect can be plugged-in.</li>
	<li><b>Pointcut:</b>one or more jointpoints at which advice should be woven.</li>
	<li><b>Aspect:</b>is a merger of advice and pointcut.what it does and where it does.</li>
	<li><b>Target:</b>the object that is being adviced</li>
	<li><b>Proxy:</b>the object created after applying advice to the target object.</li>
	<li><b>Weaving:</b>the process of applying aspects to a target object to created new proxied object.</li>
</ul>

<b>Advice Type and Description:</b><br>
<ul>
	<li><b>Before:</b>Advice that executes before the joinpoint.</li>
	<li><b>After-returning:</b>Advice to be executed after a joinpoint compltes normally.</li>
	<li><b>After-throwing:</b>Advice to be executed if a method exits by throwing an exception.</li>
	<li><b>After:</b>Advice to be executed regardless of the means by which a join point exits.</li>
	<li><b>Around:</b>Advice that surrounds a join point such a method.</li>
</ul>

<b>Pointcut Expressions:</b><br>
<ul>
	<li>execution(public **(..))</li>
	<li>execution(*set*(..))</li>
	<li>execution(*com.xyz.service.AccountService.*(..))</li>
	<li>execution(* com.xyz.service.*.*(..))</li>
	<li>within(com.xyz.service.*)</li>
	<li>within(com.xyz.service..*)</li>
	<li>target(com.xyz.service.AccountService)</li>
	<li>args(java.io.Serializable)</li>
	<li>bean(tradeService)</li>
	<li>bean(*Service)</li>
</ul>

<b>Reusing Pointcut Expressions:</b><br>
<ul>
	<li>
		@Pointcut("execution(public **(..))")
			private void anyPublicOperation(){}
	</li>
	<li>
		@Pointcut("within(com.xyz.service.trading..*)")
			private void inTrading(){}
	</li>
	<li>
		aop:pointcut expression="execution(* org.springaopexamples.target.BankImpl.getBalance(*))" id="logBeforePointcut"
	</li>
</ul>

<hr>
<b>following are the advices:</b><br>
	
		public void logBefore(){
		}
		
		public void logAfter(){
		}

<b>Following are the Joinpoints in examples:</b><br>


			public double getBalance(){

				return balance;
			}

			public void transfer(long creditAc,long debitAcc){

			}

			public boolean isValidCard(long cardno){
				return false;
			}
			
<b>following is one of the pointcut:</b> <br>

			public double getBalance(){

				return balance;
			}
<b>following is the target object:</b><br>

			BankImpl.class

			
<b>following are the aspect:</b><br>

		public void logBefore(){
		}
		
		public double getBalance(){
				return balance;
		}
<hr>
<b>Spring aop configuration</b><br>

	<aop:config>
	   	<aop:aspect ref="loggingAspect">
	   		<aop:pointcut expression="execution(* org.springaopexamples.target.BankImpl.getBalance(*))" id="logBeforePointcut"/>
	   		<aop:before pointcut-ref="logBeforePointcut" method="logBefore"/>
	   		<aop:after pointcut-ref="logBeforePointcut" method="logAfter"/>
	   		<aop:before pointcut-ref="logBeforePointcut" method="logBeforeWithPointcutInfo"/>
	   	</aop:aspect>
	 </aop:config>

<b>Spring AOP AspectJ Pointcut Expressions With Examples:</b>
<hr>

<ol>
	<li><b>Matching Method Signature Patterns:</b>
	<ul>
	<li>Matching all methods within a class in another package:<br>
		For example, the following pointcut expression matches all of the methods declared in the IBank interface. <br>
		The preceding wildcard matches methods with any modifier (public, protected, and private) and any return type. <br>
		The two dots in the argument list match any number of arguments.<br><br></li>

		<b>execution(* org.springaopexamples.target.IBank.*(..)) </b> </i>

	<li>Matching all methods within a class within same package:<br>
	 You can omit the package name if the target class or interface is located in the same package as this aspect..<br><br>
	  <b>execution(* IBank.*(..))</b> 
	</li>
	<li>Matching all public methods in IBank:<br>
	 Use public keyword in start, and use * to match any return type.<br><br>
	  <b>execution(public * IBank.*(..))</b> 
	</li>
	<li>Matching all public methods in IBank with return type BankDto:<br>
	 Use public keyword and return type in start.<br><br>
	  <b>execution(public BankDto IBank.*(..))</b> 
	</li>
	<li>Matching all public methods in IBank with return type BankDto and first parameter as BankDto:<br>
	 Use public keyword and return type in start. Also, specify your first parameter as well. Rest parameters can be matched through two dots.<br><br>
	  <b>execution(public BankDto IBank.*(BankDto, ..))</b> 
	</li>
	<li>Matching all public methods in IBank with return type BankDto and definite parameters:<br>
	 Use public keyword and return type in start. Also, specify all parameter types as well.<br><br>
	  <b>execution(public BankDto IBank.*(BankDto, Integer))</b> 
	</li>
	</ul>
	</li>
	
	<li><b>Matching Type Signature Patterns:</b>
	<ul>
	<li>Matching all methods defined in classes inside package com.springaopexamples.aop:<br>
	It’s much like previous example. <br><br>
	  <b>within(com.springaopexamples.aop.*)</b> 
	</li>
	<li>Matching all methods defined in classes inside package com.springaopexamples.aop and classes inside all sub-packages as well:<br>
	 For including, sub-packages use two dots.<br><br>
	  <b>within(com.springaopexamples.aop..*)</b> 
	</li>
	<li>Match all methods with a class in another package:<br>
	 Much like previous example using execution keyword.<br><br>
	  <b>within(com.springaopexamples.target.BankImpl)</b> 
	</li>
	<li>Match all methods with a class in same package:<br>
	 in case of same package, drop package name.<br><br>
	  <b>within(BankImpl)</b> 
	</li>
	<li>Match all methods within all all implementing classes of IBank interface:<br>
	 Use + (plus) sign to match all implementations of an interface.<br><br>
	  <b>within(BankImpl+)</b> 
	</li>
	</ul>
	</li>
	
	<li><b>Matching Bean Name Patterns:</b>
	<ul>
	<li>Match all methods defined in beans whose name ends with ‘Manager’:<br>
	 It’s quite easy one. Use an * to match anything preceding in bean name and then matching word.<br><br>
	  <b>bean(*Manager)</b> 
	</li>
	</ul>
	</li>
	
	<li><b>Combining Pointcut Expressions:</b>
	<ul>
	<li>Match all methods with names ending with Manager and DAO:<br>
	Use ‘||’ sign to combine both expressions. <br><br>
	  <b>bean(*Manager) || bean(*DAO)</b> 
	</li>
	</ul>
	</li>
</ol>
