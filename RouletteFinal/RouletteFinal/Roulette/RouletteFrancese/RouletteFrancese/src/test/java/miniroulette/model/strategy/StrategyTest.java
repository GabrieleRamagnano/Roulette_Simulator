package miniroulette.model.strategy;

import miniroulette.model.combination.Combination;
import miniroulette.model.player.Player;
import miniroulette.model.strategy.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StrategyTest {

    @Test
    public void TestOnStrategyMartingale(){
        Strategy martingale  = new Martingale(Combination.BLACK.name(), 7);
        Player   player1     = new Player(150, martingale);
        Assertions.assertTrue(player1.isWin(true));
        Integer expectedBet = 7;
        Assertions.assertEquals(expectedBet, player1.getStrategy().getBet().getBetValue());
    }

    @Test
    public void TestOnStrategyFisher(){
        Strategy fisher      = new Fisher(Combination.EVEN.name(), 8);
        Player   player2     = new Player( 150, fisher);
        //Fisher
        Integer expectedBet = 24;
        Assertions.assertTrue(player2.isWin(false));
        Assertions.assertTrue(player2.isWin(false));
        Assertions.assertTrue(player2.isWin(false));
        Assertions.assertTrue(player2.isWin(false));
        Assertions.assertEquals(expectedBet, player2.getStrategy().getBet().getBetValue());

    }

    @Test
    public void TestOnStrategyAlembert(){
        Strategy alembert    = new Alembert(Combination.EVEN.name(), 5);
        Player   player3     = new Player(150, alembert);
        //Alembert
        Assertions.assertTrue(player3.isWin(true));
        Integer expectedBet = 4;
        Assertions.assertEquals(expectedBet, player3.getStrategy().getBet().getBetValue());
        Assertions.assertTrue(player3.isWin(true));
        Assertions.assertTrue(player3.isWin(true));
        Assertions.assertTrue(player3.isWin(true));
        Assertions.assertTrue(player3.isWin(true));
        expectedBet = 1;
        Assertions.assertEquals(expectedBet, player3.getStrategy().getBet().getBetValue());
        Assertions.assertTrue(player3.isWin(false));
        expectedBet = 2;
        Assertions.assertEquals(expectedBet, player3.getStrategy().getBet().getBetValue());

    }

    @Test
    public void TestOnStrategyAntiMartingale(){
        Strategy antiMart    = new AntiMartingale(Combination.RED.name(), 5);
        Player   player4     = new Player(150, antiMart);
        //AntiMartingale
        Assertions.assertTrue(player4.isWin(false));
        Integer expectedBet = 5;
        Assertions.assertEquals(expectedBet, player4.getStrategy().getBet().getBetValue());
        Assertions.assertTrue(player4.isWin(true));
        expectedBet = 10;
        Assertions.assertEquals(expectedBet, player4.getStrategy().getBet().getBetValue());

    }

    @Test
    public void TestOnStrategyContrAlembert(){
        Strategy contrAl     = new ContrAlembert(Combination.RED.name(), 5);
        Player   player5     = new Player(150, contrAl);
        //ContrAlembert
        Assertions.assertTrue(player5.isWin(false));
        Integer expectedBet = 4;
        Assertions.assertEquals(expectedBet, player5.getStrategy().getBet().getBetValue());
        Assertions.assertTrue(player5.isWin(false));
        Assertions.assertTrue(player5.isWin(false));
        Assertions.assertTrue(player5.isWin(false));
        Assertions.assertTrue(player5.isWin(false));
        expectedBet = 1;
        Assertions.assertEquals(expectedBet, player5.getStrategy().getBet().getBetValue());
        Assertions.assertTrue(player5.isWin(true));
        expectedBet = 2;
        Assertions.assertEquals(expectedBet, player5.getStrategy().getBet().getBetValue());

    }

    @Test
    public void TestOnStrategyParoli(){
        Strategy paroli      = new Paroli(Combination.RED.name(), 10);
        Player   player6     = new Player(160, paroli);
        //Paroli
        Assertions.assertTrue(player6.isWin(true));
        Assertions.assertTrue(player6.isWin(false));
        Assertions.assertTrue(player6.isWin(false));
        Integer expectedBet = 80;
        Assertions.assertEquals(expectedBet, player6.getStrategy().getBet().getBetValue());
        Assertions.assertTrue(player6.isWin(true));
        expectedBet = 10;
        Assertions.assertEquals(expectedBet, player6.getStrategy().getBet().getBetValue());
    }

    @Test
    public void TestOnStrategyFibonacci(){
        Strategy fibonacci  = new Fibonacci(Combination.BLACK.name(), 5);
        Player   player1    = new Player(150, fibonacci);
        Assertions.assertTrue(player1.isWin(true));
        Integer expectedBet = 8;
        Assertions.assertEquals(expectedBet, player1.getStrategy().getBet().getBetValue());
    }


    @Test
    public void TestOnStrategyLabouchere(){
        Strategy labouchere = new Labouchere(Combination.BLACK.name(), 1000, 2000);
        labouchere.getBet().chooseBetComb(Combination.BLACK);
        Player   player1    = new Player(200, labouchere);
        Integer expectedBet = player1.getStrategy().getBet().getBetStartValue();
        Assertions.assertTrue(player1.iDraw());
        Assertions.assertEquals(expectedBet,player1.getStrategy().getBet().getBetValue());

    }

    @Test
    public void TestOnStrategyContrLabouchere(){
        Strategy contrLabouchere = new ContrLabouchere(Combination.BLACK.name(), 100, 200);
        Player   player1    = new Player(200, contrLabouchere);
        Assertions.assertTrue(player1.getStrategy().getBet().getBetValue() < player1.getBankroll().getBankrollValue());
        Assertions.assertTrue(player1.isWin(true));


    }
}