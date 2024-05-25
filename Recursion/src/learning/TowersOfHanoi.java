package learning;

public class TowersOfHanoi {
    public static void main(String[] args) {
        int n = 3;

        towerOfHanoi(n, 'A', 'C', 'B');
    }

    private static void towerOfHanoi(int n, char frompeg, char topeg, char auxpeg) {
        if (n==1) {
            System.out.println("Move disk 1 from peg " + frompeg + " to peg " + topeg);
            return;
        }

        towerOfHanoi(n-1, frompeg, auxpeg, topeg);

        System.out.println("Move disk from peg "+ frompeg + " to peg " + topeg);

        towerOfHanoi(n-1, auxpeg, topeg, frompeg);

    }
}
