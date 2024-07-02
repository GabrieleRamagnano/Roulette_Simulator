package miniroulette.model.strategy;

public class ContrAlembert extends Alembert{

	/* creation of a class constructor */
	public ContrAlembert (String  betName, Integer betValue) {
		super(betName, betValue);
	}

	@Override
	public Integer ifWon() { return super.ifLost();}

	@Override
	public Integer ifLost() { return super.ifWon();}
	
	public String toString() {
		return "ContrAlembert";
	}

}