package miniroulette.model.strategy;

import miniroulette.model.combination.Combination;
import miniroulette.model.player.PlayerManager;


public class StrategyManager {
	
	private PlayerManager playerManager;
	private Integer valueLeast;
    private Strategy strategy;
	
    public StrategyManager(double bankrollValue) {
    	this.playerManager = new PlayerManager(bankrollValue);
    }
    
	/* metodo per decidere la puntata minima */
	public void chooseLeast(int valueLeast) {
		this.valueLeast = valueLeast;
		
	}
	
	/* metodo per scegliere la strategia */
	public void chooseStrategy(StrategyType nameStrategy, Combination combination) {
		
		switch (nameStrategy) {
		
		   case MARTINGALE:
			   
			   this.strategy = new Martingale(combination.name(), valueLeast);
			   break;
			   
		   case FISHER:
			   
			   this.strategy = new Fisher(combination.name(), valueLeast);
			   break;
			   
		   case FIBONACCI:

			   this.strategy = new Fibonacci(combination.name(), valueLeast);
			   break;

           case ALEMBERT:

			   this.strategy = new Alembert(combination.name(), valueLeast);
			   break;


           case ANTIMARTINGALE:

			   this.strategy = new AntiMartingale(combination.name(), valueLeast);
			   break;

			case CONTRALEMBERT:
				this.strategy = new ContrAlembert(combination.name(), valueLeast);
				break;

			case CONTRLABOUCHERE:
				this.strategy = new ContrLabouchere(combination.name(), valueLeast, playerManager.getBankrollValue());
				break;

			case LABOUCHERE:
				this.strategy = new Labouchere(combination.name(), valueLeast, playerManager.getBankrollValue());
				break;

			case PAROLI:
				this.strategy = new Paroli(combination.name(), valueLeast);
				break;

           default:
				System.out.println("Strategia non valida!");
		}
		this.strategy.getBet().chooseBetComb(combination);
	}
	
	/* metodo per costruire il giocatore */
	public void buildPlayer() {
		this.playerManager.addPlayer(strategy);
	}

	/* metodo che restituisce il riferimento all'oggetto ControllerPlayer */
	public PlayerManager getPlayerManager() {
		return this.playerManager;
	}
}
