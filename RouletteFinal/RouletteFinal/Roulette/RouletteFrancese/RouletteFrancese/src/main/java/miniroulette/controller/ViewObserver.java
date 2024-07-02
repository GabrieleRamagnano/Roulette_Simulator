package miniroulette.controller;

import miniroulette.model.combination.Combination;
import miniroulette.model.player.Player;
import miniroulette.model.strategy.StrategyType;
import miniroulette.view.InstructionView;
import miniroulette.view.View;

import java.util.List;

public interface ViewObserver {
	
	// metodo per far partire la simulazione
	public void simulation();
	
	// metodo per costrire il tabellone
	public void setTable();
	
	// metodo per impostare il bankroll
	public void setBankroll(double bankroll);
	
	// metodo per inizializzare i lanci
	public void setLauches(int launches);
	
	// metodo per creare i giocatori
	public void createPlayer(StrategyType strategy, int betValue, Combination combination);

	// metodo per recuperare la lista di giocatori
	public List<Player> getPlayerList();

	// metodo per cancellare tutte le strategie (i giocatori) create
	public void deleteStrategy();

	// metodo per registrare il tipo di strategia selezionata dall'utente
	public void setStrategyType(StrategyType strategy);

	// metodo per prelevare il tipo di strategia selezionata dall'utente
	public StrategyType getStrategyType();

	// metodo per impostare l'interfaccia grafica
	public void setView(InstructionView view);

	// metodo per prelevare l'interfaccia grafica
	public InstructionView getView();

}
