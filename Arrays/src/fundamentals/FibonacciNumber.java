package fundamentals;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
        System.out.println(fibonacciRecursive(n));
    }

    private static int fibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 2; i <= n ; i++ ) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    private static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
}
