package learning;

public class PowerOfNumber {
    private static int powerOfN(int a, int b) {
        int ans = 1;
        for (int i=1; i<b; i++)
            ans *= a;

        return ans;
    }

    public static void main(String[] args) {
        int a = 3, b = 5;
        System.out.println("Power of " + a + "^" + b + " : " + powerOfN(a, b));
    }
}
