package miniroulette.model.strategy;

import miniroulette.model.bet.BetOutside;
import miniroulette.model.bet.LabouchereBet;
import miniroulette.model.combination.Combination;

import java.util.LinkedList;
import java.util.Random;

public class Labouchere extends GeneralStrategy{
	/* declaration of variables */
	private LabouchereBet bet;     // current bet

	/* creation of a class constructor */
	public Labouchere (String  betName, Integer betValue, double bankroll) {
		this.bet = new LabouchereBet(betName, listOfValue(betValue, bankroll));
	}


	private LinkedList<Integer> listOfValue(int betWanted, double bankroll) {
		if (betWanted >= bankroll)
			return partitioning((int)bankroll/3, betWanted);
		else
			return partitioning(betWanted, betWanted);
	}

	private LinkedList<Integer> partitioning(int set, int betWanted) {

		Random rnd                   = new Random();
		LinkedList <Integer> betList = new LinkedList<Integer>();
		int partition = rnd.nextInt(1, set);

		int rest = betWanted - partition;
		while(rest > 0){
			betList.add(partition);
			betWanted = rest;
			partition = rnd.nextInt(1, set);
			rest = betWanted - partition;

		}

		if(rest != 0) {
			betList.add(betWanted);
		}
		return  betList;
	}

	protected void iWon() {this.bet.setBetValue(winBetPartition());}

	/* method to set bet's value when player lost */
	protected void iLost() {this.bet.setBetValue(loseBetPartition());}

	/* method to select a bet's type*/

	@Override
	public void chooseBet(Combination combination) {
		this.bet.chooseBetComb(combination);
	}

	/* method to select bet */
	@Override
	public BetOutside getBet() {
		return this.bet;
	}

	private Integer winBetPartition(){
		int size = this.bet.getListBetValues().size();
		int betV;
		if(size == 1 || size == 2) {
			betV = 0;
		} else {
			this.bet.getListBetValues().removeFirst();
			this.bet.getListBetValues().removeLast();
			betV = this.bet.getListBetValues().getFirst() + this.bet.getListBetValues().getLast();
		}
		this.bet.resetDummyList();
		return betV;
	}

	private Integer loseBetPartition(){
		this.bet.getListBetValues().addLast(this.bet.getBetValue());
		int j = this.bet.getListBetValues().getFirst() + this.bet.getListBetValues().getLast();
		this.bet.resetDummyList();
		return j;
	}
	@Override
	public Integer ifWon() {
		int size = this.bet.getListBetValues().size();
		int betV;
		if(size == 1 || size == 2) {
			betV = 0;
		} else {
			this.bet.getDummyList().removeFirst();
			this.bet.getDummyList().removeLast();
			betV = this.bet.getDummyList().getFirst() + this.bet.getDummyList().getLast();
			this.bet.resetDummyList();
		}
		return betV;
	}


	@Override
	public Integer ifLost() {
		this.bet.getDummyList().addLast(this.bet.getBetValue());
		int j = this.bet.getDummyList().getFirst() + this.bet.getDummyList().getLast();
		this.bet.resetDummyList();
		return j;
	}

	public String toString() {
		return "Labouchere";
	}
}
