package fundamentals;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int n = 153;
        boolean flag = isArmstrong(n);
        if (flag)
            System.out.println(n + " is an Armstrong number.");
        else
            System.out.println(n + " is not an Armstrong number.");
    }

    private static boolean isArmstrong(int n) {
        int sum = 0;
        int temp = n;
        while (n != 0) {
            int remainder = n % 10;
            n = n/10;
            sum = sum + (remainder * remainder * remainder);
        }
        if (sum == temp)
            return true;
        else
            return false;
    }
}
