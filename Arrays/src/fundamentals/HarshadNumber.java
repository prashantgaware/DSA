package fundamentals;

public class HarshadNumber {
    public static void main(String[] args) {
        int n = 18;
        boolean flag = isHarshad(n);
        if (flag)
            System.out.println(n + " is a Harshad number.");
        else
            System.out.println(n + " is not a Harshad number.");
    }

    private static boolean isHarshad(int n) {
        int sum = 0;
        int temp = n;
        while (n != 0) {
            int remainder = n % 10;
            n = n/10;
            sum = sum + remainder;
        }

        if (temp % sum == 0)
            return true;
        else
            return false;
    }
}
