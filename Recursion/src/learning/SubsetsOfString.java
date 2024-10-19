package learning;

public class SubsetsOfString {
    public static void main(String[] args) {
        String str = "ABCDE";
        subsets(str, 0, "");
    }

    // Print all the subsets of a string
    // Approach: At each index, we have two choices, either to include the character or not.
    // 1. If we include the character, then we will call the function recursively with the next index and the character.
    // 2. If we do not include the character, then we will call the function recursively with the next index and the empty string.
    // 3. If we reach the end of the string, then we will print the string.
    // Time Complexity: O(2^n)
    private static void subsets(String str, int i, String s) {
        if (i == str.length()) {
            System.out.println(s);
            return;
        }

        subsets(str, i+1, s+str.charAt(i));
        subsets(str, i+1, s);
    }
}
