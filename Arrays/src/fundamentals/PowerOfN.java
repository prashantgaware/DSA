package fundamentals;

public class PowerOfN {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = powerOfN(base, exponent);
        System.out.println(base + " raised to the power " + exponent + " is " + result);
    }

    private static int powerOfN(int base, int exponent) {
        if (exponent == 0)
            return 1;
        else
            return base * powerOfN(base, exponent-1);
    }
}
