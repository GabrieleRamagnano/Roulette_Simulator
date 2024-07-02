package miniroulette.model.bankroll;

public class Bankroll {

	private static final Double EMPTY = 0.0;
	private Double bankroll;
	private Double startBankroll;
	
	/*
	 * Costruttore
	 */
	public Bankroll(Double bankroll) {
		this.bankroll      = bankroll;
		this.startBankroll = this.bankroll;
	}
	

	public Double getBankrollValue() {
		return bankroll;
	}
	
	public Double getStartBankroll() {
		return this.startBankroll;
	}
	
	private boolean isBankrollEmpty() {
		if(this.bankroll > EMPTY) 
		   return false;
		else 
		   return true;
	}
	
	public boolean isBankrollEnough(int nextBetValue) {
		if (!isBankrollEmpty() && getBankrollValue() >= nextBetValue && nextBetValue > 0)
		  return true;
		else
		  return false;
	}
	
	public void increaseBankroll(double betValue) {
		 this.bankroll += betValue;
	}
	
	public void decreaseBankroll(double betValue) {
		 this.bankroll -= betValue;
	}

	
}

