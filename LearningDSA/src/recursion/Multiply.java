package recursion;

// Write a program to find n*m (n & m are positive integers) using recursion.

import java.util.Scanner;

public class Multiply {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter M : ");
        int m = scanner.nextInt();
        System.out.print("Enter N : ");
        int n = scanner.nextInt();

        int mul = mul(m, n);
        System.out.println(mul);

    }

    static int mul(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        else
            return m + mul(m, n-1);
    }
}
