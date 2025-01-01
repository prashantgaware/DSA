package potd.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Gfg_01Jan_PrintAnagramTogether {
    public static void main(String[] args) {
        String[] arr = {"cat", "dog", "tac", "god", "act"};
        ArrayList<ArrayList<String>> result = anagrams(arr);
        for (ArrayList<String> list : result) {
            System.out.println(list);
        }
    }

    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : arr) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedString, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
