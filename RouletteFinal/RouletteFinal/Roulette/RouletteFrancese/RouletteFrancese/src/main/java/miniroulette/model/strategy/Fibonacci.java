package miniroulette.model.strategy;

import miniroulette.model.bet.BetOutside;
import miniroulette.model.bet.GeneralBet;
import miniroulette.model.combination.Combination;
import miniroulette.model.main.utilities.FibonacciUtilities;

public class Fibonacci extends GeneralStrategy{

	/* declaration of variables */
	private BetOutside bet;     // current bet
	
	/* creation of a class constructor */
	public Fibonacci(String  betName, Integer betValue) {
		this.bet = new GeneralBet(betName, betValue);

	}

	
	protected void iWon() {
		
		this.bet.setBetValue(ifWon());
	} 
	
	/* method to set bet's value when player lost */
	protected void iLost() {
		this.bet.setBetValue(ifLost());
	}
	
	
	private int searchIndex(int n) {

       var index = FibonacciUtilities.searchIndex(n);

	    if (index != 0) {
	      int indexPrevious = index - 1;
	      return FibonacciUtilities.fibonacci(indexPrevious);
	    }
	    else
	      return 1;

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
		return "Fibonacci";
	}

	@Override
	public Integer ifWon() {
		// TODO Auto-generated method stub
		return searchIndex(this.bet.getBetValue()) + this.bet.getBetValue();
	}

	@Override
	public Integer ifLost() {
		// TODO Auto-generated method stub
		return searchIndex(this.bet.getBetValue());
	}

}
