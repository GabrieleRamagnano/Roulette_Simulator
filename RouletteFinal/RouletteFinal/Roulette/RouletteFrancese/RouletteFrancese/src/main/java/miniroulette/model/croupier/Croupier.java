package miniroulette.model.croupier;

import miniroulette.model.player.Player;

import java.util.*;


public class Croupier{
	
	/* campi della classe */
	final private Random random;
	final private List<Player> winners;
	private List<Player> dummyPlayers;
	
	/* definizione del costruttore */
	public Croupier() {
		this.random       = new Random();
		this.winners      = new ArrayList<>();
		this.dummyPlayers = new LinkedList<>();
	}
	
	/* metodo per l'estrazione del numero: avvio del gioco */
	public int spinRoulette() {
		this.winners.clear();
		return random.nextInt(37);
	}
	
	/* metodo per dimezzare la puntata */
	public void split(List<Player> playersRemained, HashMap<Integer, List<Player>> outsidePlayers) {
		this.dummyPlayers.addAll(playersRemained);
		if (!playersRemained.isEmpty()) {
			playersRemained.forEach(p -> {
						p.getBankroll().decreaseBankroll(p.getStrategy().getBet().getBetComb()
								.isZero(p.getStrategy().getBet().getBetValue()));
						p.addBalance();
					});
			this.dummyPlayers.stream()
					.filter(Player::iDraw)
					.forEach(p -> {
						outsidePlayers.get(p.getStrategy().getBet().getBetComb().getComb().ordinal()).remove(p);
						playersRemained.remove(p);
					});
			this.dummyPlayers.clear();

		}
	}
	
	
	/* metodo per raccogliere i vincitori */
	public void manageWinners(List<Player> outsideWinners, List<Player> playersRemained) {
		this.dummyPlayers.addAll(outsideWinners);
		if (!outsideWinners.isEmpty()) {
			winners.addAll(outsideWinners);
			outsideWinners.forEach(p -> {p.getBankroll().increaseBankroll(p.getStrategy().getBet().getBetComb()
                    				      .increaseBet(p.getStrategy().getBet().getBetValue())); p.addBalance();});
			this.dummyPlayers.stream()
	    	              .filter(p -> !p.isWin(true))
	    	              .forEach(p -> {outsideWinners.remove(p); playersRemained.remove(p);});
			this.dummyPlayers.clear();

		}
    } 
	
	/* metodo per raccogliere i perdenti */
	public void manageLosers(List<Player> playersRemained, HashMap<Integer, List<Player>> outsidePlayers) {
		Set<Player> res = new LinkedHashSet<>();

		playersRemained.stream()
				.filter(p -> !(this.winners.contains(p)))
				.forEach(res::add);
		if (!playersRemained.isEmpty()) {
			res.forEach(p -> {p.getBankroll().decreaseBankroll(p.getStrategy().getBet().getBetComb()
								    .increaseBet(p.getStrategy().getBet().getBetValue()));p.addBalance();});
			res.stream().filter(p -> !p.isWin(false))
					    .forEach(p -> {outsidePlayers.get(p.getStrategy().getBet().getBetComb().getComb().ordinal()).remove(p);
						               playersRemained.remove(p);});
		}
	}
}

