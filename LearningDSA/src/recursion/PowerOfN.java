package recursion;

// Write a program to calculate a n^m (n & m are +ve integers) using recursion.

import java.util.Scanner;

public class PowerOfN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter M : ");
        int m = scanner.nextInt();
        System.out.print("Enter N : ");
        int n = scanner.nextInt();

        int pow = power(m, n);
        System.out.println(pow);
    }

    static int power(int m, int n) {
        if (m == 0)
            return 1;
        else
            return n * power(m -1, n);
    }
}
