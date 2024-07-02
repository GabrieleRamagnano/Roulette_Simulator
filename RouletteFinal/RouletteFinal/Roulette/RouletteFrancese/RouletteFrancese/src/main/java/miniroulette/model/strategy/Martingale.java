package miniroulette.model.strategy;

import miniroulette.model.bet.BetOutside;
import miniroulette.model.bet.GeneralBet;
import miniroulette.model.combination.Combination;

public class Martingale extends GeneralStrategy {
	/* declaration of variables */
	private BetOutside bet; // current bet

	/* creation of a class constructor */
	public Martingale(String  betName, Integer betValue) {
		this.bet = new GeneralBet(betName, betValue);
	}


	@Override
	public Integer ifWon() {
		// TODO Auto-generated method stub
		return this.bet.getBetStartValue();
	}

	@Override
	public Integer ifLost() {
		// TODO Auto-generated method stub
		return this.bet.getBetValue() * 2;
	}

	/* method to set bet's value when player won */
	protected void iWon() {
		this.bet.setBetValue(ifWon());
	}

	/* method to set bet's value when player lost */
	protected void iLost() {this.bet.setBetValue(ifLost());}

	/* method to select a bet's type*/
	@Override
	public void chooseBet(Combination combination) {
		this.bet.chooseBetComb(combination);
	}

	/* method to select bet */
	public BetOutside getBet() {
		return this.bet;
	}

	public String toString() {
		return "Martingale";
	}


	
}
