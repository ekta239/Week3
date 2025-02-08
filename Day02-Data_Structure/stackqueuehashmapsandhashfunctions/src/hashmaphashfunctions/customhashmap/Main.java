package hashmapsandhashfunctions.customhashmap;


public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(10);

        // Insertion
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        // Retrieval
        System.out.println("Value for 'Two': " + map.get("Two")); // Output: 2
        System.out.println("Value for 'Three': " + map.get("Three")); // Output: 3

        // Size of the map
        System.out.println("Size of map: " + map.size()); // Output: 4

        // Deletion
        map.remove("Two");
        System.out.println("Value for 'Two' after deletion: " + map.get("Two")); // Output: null
        System.out.println("Size of map after deletion: " + map.size()); // Output: 3
    }
}