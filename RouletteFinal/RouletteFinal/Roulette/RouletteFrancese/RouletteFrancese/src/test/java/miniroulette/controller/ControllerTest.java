package miniroulette.controller;

import miniroulette.controller.Controller;
import miniroulette.controller.ViewObserver;
import miniroulette.model.combination.Combination;
import miniroulette.model.main.RouletteGameModel;
import miniroulette.model.strategy.StrategyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


public class ControllerTest {
    private static final int  TIMEOUT = 60000 * 20;

    @Test
    public void StressTestOnPlayersCreation(){
        ViewObserver controller = new Controller(new RouletteGameModel());
        controller.setTable();
        controller.setBankroll(60000);
        for (int i = 1; i <= 10000; i++) {
            controller.createPlayer(StrategyType.MARTINGALE, i, Combination.RED);
            controller.createPlayer(StrategyType.ALEMBERT, i, Combination.RED);
            controller.createPlayer(StrategyType.PAROLI, i, Combination.RED);
            controller.createPlayer(StrategyType.FISHER, i, Combination.RED);
            controller.createPlayer(StrategyType.ANTIMARTINGALE, i, Combination.RED);
            controller.createPlayer(StrategyType.CONTRALEMBERT, i, Combination.RED);
            controller.createPlayer(StrategyType.ALEMBERT, i, Combination.EVEN);
            controller.createPlayer(StrategyType.FISHER, i, Combination.BLACK);

        }
        Assertions.assertEquals(80000, controller.getPlayerList().size());
    }

    @Test
    @Timeout (TIMEOUT)
    public void StressTestOnSimulation(){
        ViewObserver controller2 = new Controller(new RouletteGameModel());
        controller2.setTable();
        controller2.setBankroll(60000);
        controller2.setLauches(30);
        for (int i = 10000; i < 20000; i++) {
            controller2.createPlayer(StrategyType.MARTINGALE, i, Combination.UPPER);
            controller2.createPlayer(StrategyType.ANTIMARTINGALE, i, Combination.LOWER);
            controller2.createPlayer(StrategyType.ALEMBERT, i, Combination.UPPER);
            controller2.createPlayer(StrategyType.PAROLI, i, Combination.UPPER);
            controller2.createPlayer(StrategyType.FISHER, i, Combination.LOWER);
            controller2.createPlayer(StrategyType.CONTRALEMBERT, i, Combination.RED);
            controller2.createPlayer(StrategyType.ALEMBERT, i, Combination.EVEN);
            controller2.createPlayer(StrategyType.FISHER, i, Combination.BLACK);
        }
        controller2.simulation();
        // best time: 17min, 32s
    }


}