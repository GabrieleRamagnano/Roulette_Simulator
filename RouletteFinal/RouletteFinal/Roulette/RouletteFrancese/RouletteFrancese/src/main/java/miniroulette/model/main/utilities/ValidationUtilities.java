package miniroulette.model.main.utilities;

import miniroulette.model.strategy.StrategyType;

public class ValidationUtilities extends FibonacciUtilities {

    final private static String ERROR  = "Non è un numero di fibonacci!";
    public static boolean LabouchereValidation(StrategyType strategy){
        return !(strategy.equals(StrategyType.LABOUCHERE) || strategy.equals(StrategyType.CONTRLABOUCHERE));

    }

    public static void FibonacciValidation(int n){
        int index  = 0;
        int numero = 0;
        while (numero != n) {
            index++;
            numero = fibonacci(index);
            if (numero > n)
                throw new IllegalArgumentException(ERROR);
        }
    }

}
