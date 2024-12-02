package Fenster;

public class FibCalculator {

    public long calculateFibonacci(long n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1, sum;
        for (long i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
