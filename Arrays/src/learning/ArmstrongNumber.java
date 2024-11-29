package learning;

public class ArmstrongNumber {
    private static boolean armstrongNumb(int num) {
        int temp = num;
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            num = num / 10;
            sum = sum + (rem * rem * rem);
        }

        return temp == sum;
    }

    public static void main(String[] args) {
        System.out.println("Is armstrong : " + armstrongNumb(134));
        System.out.println("Is armstrong : " + armstrongNumb(127));
        System.out.println("Is armstrong : " + armstrongNumb(153));
    }
}
