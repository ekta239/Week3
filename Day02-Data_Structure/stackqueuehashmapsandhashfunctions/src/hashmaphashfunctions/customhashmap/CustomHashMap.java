package hashmapsandhashfunctions.customhashmap;

import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private LinkedList<Node<K, V>>[] table;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // Update existing key
                return;
            }
        }

        // If key does not exist, add a new node
        bucket.add(new Node<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value; // Return the value if key is found
            }
        }

        return null; // Return null if key is not found
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node); // Remove the node if key is found
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }
}