package recursion;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N : ");
        int n = scanner.nextInt();

        int f = fact(n);
        System.out.println(f);
    }

    public static int fact(int n) {
        if(n == 0)
            return 1;
        else
            return n * fact(n-1);
    }
}
