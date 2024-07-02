package miniroulette.model.main;

import miniroulette.model.combination.Combination;
import miniroulette.model.player.Player;
import miniroulette.model.strategy.StrategyType;

import java.util.List;

public interface Model {
    public void setTable();

    public void setBankroll(double bank);

    public void setLaunch(int launchNumber);

    public void createPlayer(StrategyType strategy, int betValue, Combination combination);

    public List<Player> getPlayers();

    public void removePlayers();

    public void startSimulation();
}
