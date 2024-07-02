package miniroulette.model.main.utilities;

public class FibonacciUtilities {

    public static int searchIndex(int n){
        int index  = 0;
        int numero = 0;
        while (numero != n) {
            index++;
            numero = fibonacci(index);
        }
        return index;
    }

    public static int fibonacci(int n) {
        int fib;
        if (n == 0 || n == 1)
            fib = 1;
        else
            fib = fibonacci(n - 1) + fibonacci(n - 2);
        return fib;

    }
}
