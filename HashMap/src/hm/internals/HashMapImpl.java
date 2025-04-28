package hm.internals;

public class HashMapImpl<K, V> {

    /**
     * HashMapNode class to represent each node in the hash map.
     * This class contains the key, value, and a reference to the next node
     * in case of collisions (chaining).
     * @param <K>
     * @param <V>
     */
    private static class HashMapNode<K, V> {
        K key;
        V value;
        HashMapNode<K, V> next;

        public HashMapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final HashMapNode[] table;
    private final int capacity;
    private int size;

    public HashMapImpl(int capacity) {
        this.capacity = capacity;
        this.table = new HashMapNode[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashMapNode<K, V> newNode = new HashMapNode<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            HashMapNode<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Update existing value
                    return;
                }
                current = current.next;
            }
            newNode.next = table[index]; // Insert at the beginning of the linked list
            table[index] = newNode;
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashMapNode<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = hash(key);
        HashMapNode<K, V> current = table[index];
        HashMapNode<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next; // Remove first node
                } else {
                    previous.next = current.next; // Remove middle or last node
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < capacity; i++) {
            HashMapNode<K, V> current = table[i];
            while (current != null) {
                sb.append(current.key).append(" = ").append(current.value).append(", ");
                current = current.next;
            }
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2); // Remove last comma and space
        }
        sb.append(" }");
        return sb.toString();
    }
}
