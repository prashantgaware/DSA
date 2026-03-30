package hm.internals;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CustomLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "A");
        linkedHashMap.put(3, "A");
        linkedHashMap.put(4, "A");
        linkedHashMap.put(2, "A");
        linkedHashMap.put(5, "A");

        linkedHashMap.forEach((key, value) -> {
            System.out.println("Key: " + key + ", " + "Value: " + value);
        });

        HashMap<Integer, String> map = new HashMap<>(linkedHashMap);
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", " + "Value: " + value);
        });
    }
}
