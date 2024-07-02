package miniroulette.model.bet;

import miniroulette.model.combination.Combination;
import miniroulette.model.combination.Outside;
import miniroulette.model.combination.OutsideComb;

import java.util.Random;


public class GeneralBet implements BetOutside{
	/* declaration of variables */
	private String betName;          // bet's name
	private Integer betStartValue;   // start bet's value
	private Integer betValue;        // current bet's value
	private OutsideComb betComb;  // bet's combination
	
	/* creation of a class constructor */
	public GeneralBet(String betName, Integer betValue) {
		this.betName = betName;
		this.betStartValue = betValue;
		this.betValue = this.betStartValue;
	}
	
	/* method to select one number from 1 to 5 */
	private Integer randomPick() {
		
		Random Random = new Random();
		int pickBet = Random.nextInt(6);
		
		return pickBet;
	}
	
	/* method to select the type of combination outside */
	@Override
	public void chooseBetComb(Combination combination) {
		
		if (combination != Combination.RANDOM)
		  this.betComb = new Outside(combination);
		else {
			// TODO Auto-generated method stub
			int randomPickBet = randomPick(); // pick random number 
			//arrayList with all of type of Bets

			//assign value of random pick
			this.betComb = new Outside(Combination.values()[randomPickBet]);
		}
	}

	/* method to get a bet's start value */
	@Override
	public Integer getBetStartValue() {
		return this.betStartValue;
	}
	
	/* method to get a bet's current value */
	@Override
	public Integer getBetValue() {
		return this.betValue;
	}
	
	/* method to set a bet's value */
	@Override
	public void setBetValue(Integer value) {
		this.betValue = value;
	}

	/* method to get a bet's name to type of select combination */
	@Override
	public String getBetName() {
		return this.betName;
	}	

	@Override
	public OutsideComb getBetComb() {return this.betComb;}



}


