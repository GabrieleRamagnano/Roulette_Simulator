package miniroulette.model.main;

import miniroulette.model.combination.Combination;
import miniroulette.model.croupier.GameManager;
import miniroulette.model.main.utilities.ValidationUtilities;
import miniroulette.model.player.Player;
import miniroulette.model.strategy.StrategyType;

import java.util.List;

public class RouletteGameModel implements Model{

	final private static Double EMPTY  = 0.0;
	final private static String ERR_BANKROLL = "Il bankroll deve essere positivo";
	final private static String ERR_LAUNCHES = "Il numero di lanci deve essere positivo";
	final private static String ERR_BET = "La posta deve essere positiva";
	final private static String ERR_BET_SIZE = "Il valore della posta non può superare il valore del bankroll";
	private Double bankroll;
	private Integer launch;
	private GameManager gameManager;
	
	public RouletteGameModel() {
		this.gameManager = new GameManager();
	}
	
	public void setTable() {
		this.gameManager.buildTable();
	}
	
	public void setBankroll(double bank){
		if (bank <= EMPTY)
		  throw new IllegalArgumentException(ERR_BANKROLL);
		this.bankroll   = bank;
		this.gameManager.buildStrategy(bank);
	}
	
	public void setLaunch(int launchNumber) {
		if (launchNumber <= EMPTY)
			  throw new IllegalArgumentException(ERR_LAUNCHES);
		this.launch = launchNumber;
	}
	
	public void createPlayer(StrategyType strategy, int betValue, Combination combination) {
		if (betValue <= EMPTY)
			  throw new IllegalArgumentException(ERR_BET);
		if (betValue > this.bankroll && ValidationUtilities.LabouchereValidation(strategy))
			  throw new IllegalArgumentException(ERR_BET_SIZE);
		if (strategy.equals(StrategyType.FIBONACCI))
			  ValidationUtilities.FibonacciValidation(betValue);
		this.gameManager.buildPlayer(betValue, strategy, combination);
		this.gameManager.putFiche(this.gameManager.getStrategyManager().getPlayerManager().getPlayersList().getLast());
	}
	
	public List<Player> getPlayers(){
		return this.gameManager.getStrategyManager().getPlayerManager().getPlayersList();
	}

	@Override
	public void removePlayers() {
		this.gameManager.getStrategyManager().getPlayerManager().eliminatePlayers();
	}

	public void startSimulation() {
		int l = 0;
		while (l < launch && this.gameManager.playersInGame()) {
			this.gameManager.spin();
			this.gameManager.viewOutside();
			this.gameManager.payTable();
			l++;
		}
	}
}
