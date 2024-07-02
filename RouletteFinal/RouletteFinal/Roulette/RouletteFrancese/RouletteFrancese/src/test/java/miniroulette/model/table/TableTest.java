package miniroulette.model.table;

import miniroulette.model.combination.Combination;
import miniroulette.model.table.TableManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TableTest {


    @Test
    public void TestOnNumber(){
        TableManager managerT = new TableManager();
        managerT.buildNumbers();
        Assertions.assertEquals(managerT.getNumber(11).getNumber(), 11);
        Assertions.assertEquals(managerT.getNumber(11).getColor(), Combination.BLACK.ordinal());
        Assertions.assertEquals(managerT.getNumber(11).getEvenOdd(), Combination.ODD.ordinal());
        Assertions.assertEquals(managerT.getNumber(11).getUpperLower(), Combination.UPPER.ordinal());

    }

    @Test
    public void TestOnNumberII(){
        TableManager managerT = new TableManager();
        managerT.buildNumbers();
        Assertions.assertEquals(managerT.getNumber(12).getNumber(), 12);
        Assertions.assertEquals(managerT.getNumber(32).getColor(), Combination.RED.ordinal());
        Assertions.assertEquals(managerT.getNumber(17).getEvenOdd(), Combination.ODD.ordinal());
        Assertions.assertEquals(managerT.getNumber(15).getUpperLower(), Combination.UPPER.ordinal());

    }

    @Test
    public void TestOnColor(){
        TableManager managerT = new TableManager();
        managerT.buildNumbers();
        Assertions.assertEquals(managerT.getNumber(10).getColor(), Combination.BLACK.ordinal());
        Assertions.assertEquals(managerT.getNumber(11).getColor(), Combination.BLACK.ordinal());
        Assertions.assertEquals(managerT.getNumber(18).getColor(), Combination.RED.ordinal());
        Assertions.assertEquals(managerT.getNumber(19).getColor(), Combination.RED.ordinal());
        Assertions.assertEquals(managerT.getNumber(28).getColor(), Combination.BLACK.ordinal());
        Assertions.assertEquals(managerT.getNumber(29).getColor(), Combination.BLACK.ordinal());

    }
}