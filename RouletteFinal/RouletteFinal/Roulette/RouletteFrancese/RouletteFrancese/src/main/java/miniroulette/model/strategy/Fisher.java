package miniroulette.model.strategy;

import miniroulette.model.bet.BetOutside;
import miniroulette.model.bet.GeneralBet;
import miniroulette.model.combination.Combination;

public class Fisher implements Strategy{
	
	/* declaration of variables */
	private BetOutside bet;     // current bet
	private int numLost; // lose's counter
	
	/* creation of a class constructor */
	public Fisher (String  betName, Integer betValue) {
		this.bet = new GeneralBet(betName, betValue);
		this.numLost = 0;
	}

	@Override
	public void isWin(boolean win) {
		
		if(!win) {
		  this.numLost += 1;
			if(this.numLost == 4) {
				iLost();
			} else {
				iWon();
			}
		} else {
			numLost = 0;
			iWon();
		}		
	}
	
	private void iWon() {
		this.bet.setBetValue(ifWon());
	} 
	
	/* method to set bet's value when player lost */
	private void iLost() {
		
		this.bet.setBetValue(this.bet.getBetValue() * 3);
	}

	/* method to select a bet's type*/
	@Override
	public void chooseBet(Combination combination) {
		this.bet.chooseBetComb(combination);
	}

	@Override
	public BetOutside getBet() {
		// TODO Auto-generated method stub
		return this.bet;
	}
	
	public String toString() {
		return "Fisher";
	}

	@Override
	public Integer ifWon() {
		// TODO Auto-generated method stub
		return this.bet.getBetStartValue();
	}

	@Override
	public Integer ifLost() {
		// TODO Auto-generated method stub
		if (this.numLost == 3)	
		  return this.bet.getBetValue() * 3;
		else
		  return ifWon();
	}


}
