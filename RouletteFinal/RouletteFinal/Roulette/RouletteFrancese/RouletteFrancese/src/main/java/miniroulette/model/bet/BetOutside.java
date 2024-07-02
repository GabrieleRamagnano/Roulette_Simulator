package miniroulette.model.bet;

import miniroulette.model.combination.Combination;
import miniroulette.model.combination.OutsideComb;

public interface BetOutside {
	/* interface's public methods */
	public String getBetName(); //getter Bet's name
	public Integer getBetStartValue(); //getter first Bet's value
	public Integer getBetValue(); // getter current Bet's value
	public void setBetValue(Integer value); // setter Bet's value
	public void chooseBetComb(Combination combination); // method to pick Bet's combination

	public OutsideComb getBetComb(); // getter outside combination
	
}
