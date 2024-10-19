package learning;

public class PrintNumberUsingRecursion {
    public static void main(String[] args) {
        int num = 0;
        print(num);
    }

    private static void print(int num) {
        if (num == 5) {
            return;
        }

        System.out.println(num);
        print(num+1);
    }
}
