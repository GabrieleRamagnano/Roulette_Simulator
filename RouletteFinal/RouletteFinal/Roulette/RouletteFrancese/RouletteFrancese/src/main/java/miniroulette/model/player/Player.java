package miniroulette.model.player;

import miniroulette.model.bankroll.Bankroll;
import miniroulette.model.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

	private Integer id;
	private List<Double> balance;
	private Bankroll bankroll;
	private Strategy strategy;
	
	/*
	 * Costruttore della classe player
	 */
	public Player(double value, Strategy strategy) {
		this.balance  = new ArrayList<>();
		this.bankroll = new Bankroll(value);
		this.strategy = strategy;
	}



	/* metodo per la costruzione della funzione di bilancio */
	public void addBalance() {
		this.balance.add(this.bankroll.getBankrollValue() -
						 this.bankroll.getStartBankroll());
	}

	/* iDraw, isWin: metodi per verificare la sufficienza del bankroll nella prossima giocata */
	public boolean iDraw() {
	     return !this.bankroll.isBankrollEnough(this.strategy.ifWon()) ||
				 !this.bankroll.isBankrollEnough(this.strategy.ifLost()) ||
				 !this.bankroll.isBankrollEnough(this.strategy.getBet().getBetComb()
						 .isZero(this.strategy.getBet().getBetValue()));
	}
	
	
	public boolean isWin(boolean won) {
	    if (won)
	      return ifWinNext();
	    else
	      return ifLoseNext();
	}
	
	private boolean ifWinNext() {
		var nextWin = this.bankroll.isBankrollEnough(this.strategy.ifWon());
		if (nextWin) {
		  this.strategy.isWin(true);
		}
		return nextWin;
	}
	
	private boolean ifLoseNext() {
		var nextLose = this.bankroll.isBankrollEnough(this.strategy.ifLost());
		if (nextLose) {
		  this.strategy.isWin(false);
		}
		return nextLose;
	}
	
	public int hashCode() {
		return Objects.hash(strategy, strategy.getBet().getBetStartValue(), strategy.getBet().getBetComb().getComb());
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Player other)) {
			return false;
		}
		return Objects.equals(strategy.toString(), other.strategy.toString()) &&
				strategy.getBet().getBetStartValue().equals(other.strategy.getBet().getBetStartValue()) &&
			   Objects.equals(strategy.getBet().getBetComb().getComb(), other.strategy.getBet().getBetComb().getComb());
		
	}

	public Integer getId() { return this.id; }

	public List<Double> getBalance(){
		return this.balance;
	}
	public Bankroll getBankroll() {
		return this.bankroll;
	}

	public Strategy getStrategy() {
		return this.strategy;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}


