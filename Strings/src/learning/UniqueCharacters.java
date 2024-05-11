package learning;

// Implement an algorithm to determine if a string has all unique characters.

import java.util.HashSet;
import java.util.Scanner;

public class UniqueCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String1 : ");
        String str1 = scanner.next();

        System.out.print("Enter String2 : ");
        String str2 = scanner.next();

        System.out.println("String \"" + str1 + "\" has all unique characters: " + hasUniqueCharactersUsingHashSet(str1));
        System.out.println("String \"" + str2 + "\" has all unique characters: " + hasUniqueCharactersUsingHashSet(str2));

        System.out.println("String \"" + str1 + "\" has all unique characters: " + hasUniqueCharactersUsingArrays(str1));
        System.out.println("String \"" + str2 + "\" has all unique characters: " + hasUniqueCharactersUsingArrays(str2));

    }

    private static boolean hasUniqueCharactersUsingHashSet(String str) {
        HashSet<Character> hashSet = new HashSet<>();

        for (char c: str.toCharArray()) {
            if (hashSet.contains(c))
                return false;
            hashSet.add(c);
        }

        return true;
    }

    private  static boolean hasUniqueCharactersUsingArrays(String str) {
        if (str.length() > 256) {
            return false;
        }

        boolean[] charSet = new boolean[256];

        for (int i=0; i<str.length(); i++) {
            int val = str.charAt(i);

            if (charSet[val])
                return false;
            charSet[val] = true;
        }

        return true;
    }
}
