package sorting.selection;

/*
* Given an array of name of fruits , you are supposed to sort it in lexicographical order
* using Selection Sort
*
* Input : ["papaya", "lime", "watermelon", apple, mango, kiwi]
*
* Output: [apple, kiwi, lime, mango, papaya, watermelon]
* */

public class Problem01 {
    public static void main(String[] args) {
        String[] fruits = {"papaya", "lime", "watermelon", "apple", "mango", "kiwi"};
        sortFruits(fruits);

        for (String val: fruits) {
            System.out.print(val + "  ");
        }
    }

    private static void sortFruits(String[] fruits) {
        int numberOfFruits = fruits.length;

        for (int i = 0; i<=numberOfFruits-2; i++) {
            int minIndex = i;

            for (int j = i; j<=numberOfFruits-1; j++) {
                if (fruits[j].compareTo(fruits[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            String temp = fruits[minIndex];
            fruits[minIndex] = fruits[i];
            fruits[i] = temp;
        }
    }

}
