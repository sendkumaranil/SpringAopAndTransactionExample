# SpringAopAndTransactionExample
Spring Aspect Oriented Programming and Transaction Management
<hr>
Spring AOP
----------
Spring Aspect Oriented Programming (AOP) provided solution of cross-cutting concern.

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
