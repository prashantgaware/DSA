package top150interview.array_string;

/*
* 28. Find the Index of the First Occurrence in a String
*
* Given two strings, haystack and needle, return the index of the first occurrence of
* needle in haystack, or -1 if needle is not part of haystack.
* */

public class LC_28_FindTheIndexOfTheFirstOccurrenceInString {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int needleLength = needle.length();
        for (int i = 0; i < haystack.length() - needleLength + 1; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
