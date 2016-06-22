package org.springaopexamples.target;

public class BankImpl implements IBank {

	@Override
	public double getBalance(long accounNo) {
		
		double balance=12450.00;
		System.out.println("getting balance...from account "+accounNo);
		return balance;
	}

	@Override
	public void transfer(long creditAcountNo, long debitAccountNo,double amount) {
		System.out.println("you transfered amount "+amount+" from account "+creditAcountNo+" to account "+debitAccountNo);
	}

	@Override
	public boolean isValidCard(long cardNo) {
		System.out.println("Card Validation start...");
		return false;
	}

	@Override
	public void deposit(long accountno, double amount) {
		
		System.out.println("deposited amount:"+amount+" to the account:"+accountno);
	}
}
