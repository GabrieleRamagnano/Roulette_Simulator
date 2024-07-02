package miniroulette.model.strategy;

import miniroulette.model.bet.BetOutside;
import miniroulette.model.bet.GeneralBet;
import miniroulette.model.combination.Combination;

public class Paroli implements Strategy {
	
	//vincere tre volte consecutivi poi sulla posta iniziale
	//se perdi, ripunta lo stessa cifra
	//bisogna ricordare il valore iniziale
	
	/* declaration of variables */
	private BetOutside bet; // current bet
	private int numLost; // lose's counter
	
	/* creation of a class constructor */
	public Paroli(String  betName, Integer betValue) {
		this.bet = new GeneralBet(betName, betValue);
		this.numLost = 0;
	}
	
	/* method to set bet's value when player won or lost */
	@Override
	public void isWin(boolean win) {
		checkNumBet();
	}

	private void checkNumBet() {

		if(this.numLost == 3) {
			iWon();
			this.numLost = 0;
		} else {
			iLost();
			this.numLost += 1;
		}

	}

	/* method to set bet's value when player won */
	protected void iWon() {
		this.bet.setBetValue(this.bet.getBetStartValue());
	} 
	
	/* method to set bet's value when player lost */
	protected void iLost() {
		this.bet.setBetValue(this.bet.getBetValue() * 2);
	}
	
	/* method to select a bet's type*/
	@Override
	public void chooseBet(Combination combination) {
		this.bet.chooseBetComb(combination);
	}

	/* method to select bet */
	public BetOutside getBet() {
		return this.bet;
	}

	@Override
	public Integer ifWon() {
		return nextStep();
	}

	@Override
	public Integer ifLost() { return nextStep(); }

	private Integer nextStep() {
		if (this.numLost == 2)
			return this.bet.getBetStartValue();
		else
			return this.bet.getBetValue() * 2;
	}

	public String toString() {
		return "Paroli";
	}

}
