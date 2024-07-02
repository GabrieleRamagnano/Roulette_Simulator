package miniroulette.model.croupier;

import miniroulette.model.combination.Combination;
import miniroulette.model.player.Player;
import miniroulette.model.strategy.StrategyManager;
import miniroulette.model.strategy.StrategyType;
import miniroulette.model.table.Number;
import miniroulette.model.table.TableManager;


public class GameManager {
	
	private StrategyManager strategyManager;
	final private TableManager tableManager;
	final private Croupier croupier;
	private Number extraction;
	private Integer number;
	
	public GameManager() {
		this.tableManager = new TableManager();
		this.croupier     = new Croupier();
	}
	
	/* metodo per la costruzione delle strategie */
	public void buildStrategy(double bankrollValue) {
		this.strategyManager = new StrategyManager(bankrollValue);
	}
	
	/* metodo per la costruzione dei giocatori */
	public void buildPlayer(Integer least,
			                StrategyType strategy,
			                Combination combination) {
		this.strategyManager.chooseLeast(least);
		this.strategyManager.chooseStrategy(strategy, combination);
		this.strategyManager.buildPlayer();
	}
	
	/* metodo per la costruzione del tabellone */
	public void buildTable() {	
		this.tableManager.buildNumbers();
		this.tableManager.buildOutside();
	}
	
	/* metodo per inserire l'indirizzo di ogni giocatore nel tabellone */
	public void putFiche(Player player) {
		this.tableManager.getMappingOutside().get(player.getStrategy().getBet().getBetComb().getComb().ordinal()).add(player);
	}
	
	/* metodo per l'estrazione del numero */
	public void spin() {
		this.number = croupier.spinRoulette();
		if (this.number != 0)
	      this.extraction = this.tableManager.getNumber(this.number);
	}
	
	/* metodo per controllare le combinazioni esterne */
	public void viewOutside() {
		
		if (this.number != 0) {
		  this.croupier.manageWinners(this.tableManager.getMappingOutside().get(this.extraction.getColor()),
				                     this.strategyManager.getPlayerManager().getPlayersRemained());
		  this.croupier.manageWinners(this.tableManager.getMappingOutside().get(this.extraction.getEvenOdd()),
				  					 this.strategyManager.getPlayerManager().getPlayersRemained());
		  this.croupier.manageWinners(this.tableManager.getMappingOutside().get(this.extraction.getUpperLower()),
				  					 this.strategyManager.getPlayerManager().getPlayersRemained());
		}else 
			this.croupier.split(this.strategyManager.getPlayerManager().getPlayersRemained(), this.tableManager.getMappingOutside());
			
	}
	
	public void payTable() {
		if (this.number != 0)
		  this.croupier.manageLosers(this.strategyManager.getPlayerManager().getPlayersRemained(), this.tableManager.getMappingOutside());
	}

	public boolean playersInGame(){
		return this.strategyManager.getPlayerManager().getPlayersRemained().size() != 0;
	}
	public StrategyManager getStrategyManager() {
		return this.strategyManager;
	}

}