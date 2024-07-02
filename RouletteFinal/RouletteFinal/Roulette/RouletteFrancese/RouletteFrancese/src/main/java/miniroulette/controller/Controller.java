package miniroulette.controller;

import miniroulette.model.combination.Combination;
import miniroulette.model.main.Model;
import miniroulette.model.player.Player;
import miniroulette.model.strategy.StrategyType;
import miniroulette.view.InstructionView;

import java.util.List;

public class Controller implements ViewObserver{

    private Model model;
    private InstructionView view;
    private StrategyType strategy;
    public Controller(Model model){
        this.model = model;
    }
    @Override
    public void simulation() {
        this.model.startSimulation();
    }
    @Override
    public void setTable() {
        this.model.setTable();
    }

    @Override
    public void setBankroll(double bankroll) {
        this.model.setBankroll(bankroll);
    }

    @Override
    public void setLauches(int launches) {
        this.model.setLaunch(launches);
    }

    public void createPlayer(StrategyType strategy, int betValue, Combination combination) {
        this.model.createPlayer(strategy,betValue, combination);
    }

    @Override
    public List<Player> getPlayerList() {
        return this.model.getPlayers();
    }

    @Override
    public void deleteStrategy() {
        this.model.removePlayers();
    }

    @Override
    public void setStrategyType(StrategyType strategy) {
        this.strategy = strategy;
    }

    @Override
    public StrategyType getStrategyType() {
        return this.strategy;
    }

    @Override
    public void setView(InstructionView view) {
        this.view = view;
    }
    @Override
    public InstructionView getView() {
        return this.view;
    }
}
