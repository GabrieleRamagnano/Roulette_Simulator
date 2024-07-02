package miniroulette.model.player;

import miniroulette.model.strategy.Strategy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlayerManager {
	
	final private static String ERROR = "Questo giocatore esiste già!";
	private LinkedList<Player> playersList;
	private List<Player> playersRemained;
	private double bankroll;

	
	public PlayerManager(double value) {
		this.bankroll         = value;
		this.playersList      = new LinkedList<>();
		this.playersRemained  = new ArrayList<>();
	}
	
	/* metodo per costruire il giocatore e inserirlo nella lista */
	public void addPlayer(Strategy strategy) {
		var p = new Player(this.bankroll, strategy);
		if (playersList.contains(p))
		  throw new IllegalArgumentException(ERROR);
		else {
		   this.playersList.add(p);
		   this.playersRemained.add(p);
		   p.setId(playersList.indexOf(p) + 1);
		}
	}
	
	/* metodo per recuperare la lista di giocatori */
	public LinkedList<Player> getPlayersList(){
		return this.playersList;
	}

	public List<Player> getPlayersRemained(){
		return this.playersRemained;
	}

	/* metodo per eliminare le liste di giocatori */
	public void eliminatePlayers(){
		this.playersList.clear();
		this.playersRemained.clear();
	}

	public double getBankrollValue() {
		return this.bankroll;
	}
	
}
