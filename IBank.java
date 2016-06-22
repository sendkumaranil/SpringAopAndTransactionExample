package org.springaopexamples.target;

public interface IBank {
public double getBalance(long accounNo);
	public void transfer(long creditAcountNo,long debitAccountNo,double amount);
	public boolean isValidCard(long cardNo);
	public void deposit(long accountno,double amount);

}
