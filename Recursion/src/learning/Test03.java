package learning;

public class Test03 {
    public static void main(String[] args) {
//        int n = printNto1(16);
        printNto1(5);
        System.out.println();
        print1toN(5);
    }

    private static void printNto1(int i) {
        if (i == 0)
            return ;
        System.out.print(i + " ");
        printNto1(i-1);

    }

    private static void print1toN(int i) {
        if (i == 0)
            return ;
        print1toN(i-1);
        System.out.print(i + " ");
    }
}
