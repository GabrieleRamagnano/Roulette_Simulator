package miniroulette.model.strategy;

public class ContrLabouchere extends Labouchere{


	/* creation of a class constructor */
	public ContrLabouchere(String  betName, Integer betValue, double bankroll) {
		super(betName, betValue, bankroll);
	}
	@Override
	protected void iLost() { super.iWon();}

	/* method to set bet's value when player lost */
	@Override
	protected void iWon() { super.iLost();}

	@Override
	public Integer ifWon() {  return super.ifLost();}

	@Override
	public Integer ifLost() { return super.ifWon();}

	public String toString() {
		return "ContrLabouchere";
	}
}
