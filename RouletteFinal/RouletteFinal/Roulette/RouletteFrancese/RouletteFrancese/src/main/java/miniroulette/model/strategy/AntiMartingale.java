package miniroulette.model.strategy;

public class AntiMartingale extends Martingale {
	
	/* creation of a class constructor */
	public AntiMartingale(String  betName, Integer betValue) {
		super(betName, betValue);
	}

	@Override
	public Integer ifWon() {
		return super.getBet().getBetValue() * 2;
	}

	@Override
	public Integer ifLost() {return super.getBet().getBetStartValue();}
	
	public String toString() {
		return "AntiMartingale";
	}
}