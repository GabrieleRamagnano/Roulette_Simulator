package miniroulette.model.strategy;

import miniroulette.model.bet.BetOutside;
import miniroulette.model.bet.GeneralBet;
import miniroulette.model.combination.Combination;

public interface Strategy {
	
	/* metodi pubblici dell'interfaccia */
	public void isWin(boolean win);
	public void chooseBet(Combination combination);
	public BetOutside getBet();
	public Integer ifWon();
	public Integer ifLost();

}
