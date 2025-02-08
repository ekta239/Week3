package singlylinkedlist.inventorymanagementsystem;

class Inventory {
    private ItemNode head;

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Add an item at a specific position
    public void addItemAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        ItemNode current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Remove an item based on Item ID
    public void removeItemById(int itemId) {
        ItemNode current = head;
        ItemNode previous = null;
        while (current != null && current.itemId != itemId) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Item with ID " + itemId + " not found.");
            return;
        }
        if (previous == null) {
            head = current.next; // Deleting the head
        } else {
            previous.next = current.next; // Bypass the current node
        }
    }

    // Update the quantity of an item by Item ID
    public void updateItemQuantity(int itemId, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Updated quantity for Item ID " + itemId + " to " + newQuantity);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item based on Item ID or Item Name
    public ItemNode searchItem(String searchTerm) {
        ItemNode current = head;
        try {
            int itemId = Integer.parseInt(searchTerm);
            while (current != null) {
                if (current.itemId == itemId) {
                    return current;
                }
                current = current.next;
            }
        } catch (NumberFormatException e) {
            // If parsing fails, search by item name
            while (current != null) {
                if (current.itemName.equalsIgnoreCase(searchTerm)) {
                    return current;
                }
                current = current.next;
            }
        }
        return null; // Item not found
    }

    // Calculate and display the total value of inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        ItemNode current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        return totalValue;
    }

    // Sort the inventory based on Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
    }

    private ItemNode mergeSort(ItemNode head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }

        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(head, criteria, ascending);
        ItemNode right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right , criteria, ascending);
    }

    private ItemNode sortedMerge(ItemNode left, ItemNode right, String criteria, boolean ascending) {
        ItemNode result = null;

        if (left == null) return right;
        if (right == null) return left;

        if (compare(left, right, criteria, ascending) <= 0) {
            result = left;
            result.next = sortedMerge(left.next, right, criteria, ascending);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next, criteria, ascending);
        }
        return result;
    }

    private ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;

        ItemNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private int compare(ItemNode a, ItemNode b, String criteria, boolean ascending) {
        int comparison = 0;
        if (criteria.equalsIgnoreCase("name")) {
            comparison = a.itemName.compareTo(b.itemName);
        } else if (criteria.equalsIgnoreCase("price")) {
            comparison = Double.compare(a.price, b.price);
        }
        return ascending ? comparison : -comparison;
    }

    // Display all items in the inventory
    public void displayInventory() {
        ItemNode current = head;
        if (current == null) {
            System.out.println("No items in inventory.");
            return;
        }
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", Item ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}