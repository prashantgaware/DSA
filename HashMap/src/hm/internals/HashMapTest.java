package hm.internals;

public class HashMapTest {
    public static void main(String[] args) {
        HashMapImpl<Integer, Object> hashMap = new HashMapImpl<>(16);

        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");

        System.out.println("HashMap contents: " + hashMap);

        System.out.println("Size of HashMap: " + hashMap.size());

        System.out.println("Value for key 3: " + hashMap.get(3));

        System.out.println("Value for key 8 (not present): " + hashMap.get(8));

        System.out.println("Removing key 4");
        hashMap.remove(4);
    }
}
