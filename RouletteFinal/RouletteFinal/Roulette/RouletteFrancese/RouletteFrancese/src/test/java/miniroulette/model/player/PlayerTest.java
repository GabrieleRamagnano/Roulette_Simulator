package miniroulette.model.player;


import miniroulette.model.combination.Combination;
import miniroulette.model.croupier.GameManager;
import miniroulette.model.player.Player;
import miniroulette.model.player.PlayerManager;
import miniroulette.model.strategy.*;
import miniroulette.model.table.NumberFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PlayerTest {


    @Test
    public void TestOnFiche(){
        Strategy martingale  = new Martingale(Combination.RED.name(), 20);
        Strategy fisher      = new Fisher(Combination.ODD.name(), 10);
        Player   player1     = new Player(100, martingale);
        Player   player2     = new Player(100, fisher);
        player1.getStrategy().chooseBet(Combination.RED);
        player2.getStrategy().chooseBet(Combination.ODD);
        NumberFactory numberFactory = new NumberFactory();
        var extraction = numberFactory.boxGenerator(3);
        Assertions.assertEquals(extraction.getColor(),   player1.getStrategy().getBet().getBetComb().getComb().ordinal());
        Assertions.assertEquals(extraction.getEvenOdd(), player2.getStrategy().getBet().getBetComb().getComb().ordinal());
    }

    @Test
    public void TestOnDuplication(){
        GameManager manager = new GameManager();
        manager.buildStrategy(200);
        manager.buildPlayer(30, StrategyType.PAROLI, Combination.UPPER);
        var player1 = manager.getStrategyManager().getPlayerManager().getPlayersList().getFirst();

        GameManager manager2 = new GameManager();
        manager2.buildStrategy(200);
        manager2.buildPlayer(30, StrategyType.PAROLI, Combination.UPPER);
        var player2 = manager2.getStrategyManager().getPlayerManager().getPlayersList().getFirst();
        Assertions.assertEquals(player1, player2);
        //Assert.assertNotEquals(player1, player2);

    }

    @Test
    public void TestOnDuplicationII(){
        GameManager manager = new GameManager();
        manager.buildStrategy(200);
        manager.buildPlayer(40, StrategyType.PAROLI, Combination.UPPER);
        var player1 = manager.getStrategyManager().getPlayerManager().getPlayersList().getFirst();

        GameManager manager2 = new GameManager();
        manager2.buildStrategy(200);
        manager2.buildPlayer(30, StrategyType.PAROLI, Combination.UPPER);
        var player2 = manager2.getStrategyManager().getPlayerManager().getPlayersList().getFirst();
        Assertions.assertNotEquals(player1, player2);

    }
}