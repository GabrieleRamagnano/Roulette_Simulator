package miniroulette.model.strategy;

import miniroulette.model.bet.BetOutside;
import miniroulette.model.bet.GeneralBet;
import miniroulette.model.combination.Combination;

public class Alembert extends GeneralStrategy{
	
	/* declaration of variables */
	private BetOutside bet; // current bet
	
	private final int UNIT = 1;
	
	/* creation of a class constructor */
	public Alembert (String  betName, Integer betValue) {
		this.bet = new GeneralBet(betName, betValue);
	}

	
	protected void iWon() {
		this.bet.setBetValue(ifWon());
	} 
	
	/* method to set bet's value when player lost */
	protected void iLost() {
		this.bet.setBetValue(ifLost());
	}

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
		if(this.bet.getBetValue() - UNIT == 0)
			return 1;
		else
			return this.bet.getBetValue() - UNIT;

	}

	@Override
	public Integer ifLost() {
		return this.bet.getBetValue() + UNIT;
	}
	
	public String toString() {
		return "Alembert";
	}

}

