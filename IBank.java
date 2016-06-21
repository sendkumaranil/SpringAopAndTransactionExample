package org.springaopexamples.target;

public interface IBank {
	public double getBalance(long accounNo);
	public void transfer(long creditAcountNo,long debitAccountNo);
	public boolean isValidCard(long cardNo);

}
