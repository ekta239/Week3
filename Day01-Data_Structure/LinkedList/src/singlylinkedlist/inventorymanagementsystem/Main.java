package singlylinkedlist.inventorymanagementsystem;

public class Main {
        public static void main(String[] args) {
            Inventory inventory = new Inventory();
    
            // Adding items
            inventory.addItemAtEnd("Laptop", 101, 10, 800.00);
            inventory.addItemAtEnd("Mouse", 102, 50, 20.00);
            inventory.addItemAtBeginning("Keyboard", 103, 30, 30.00);
            inventory.addItemAtPosition(1, "Monitor", 104, 20, 150.00);
    
            // Displaying all items
            System.out.println("All Inventory Items:");
            inventory.displayInventory();
    
            // Searching for an item
            ItemNode item = inventory.searchItem("Mouse");
            if (item != null) {
                System.out.println("Found Item: Item Name: " + item.itemName + ", Item ID: " + item.itemId);
            } else {
                System.out.println("Item not found.");
            }
    
            // Updating an item's quantity
            inventory.updateItemQuantity(101, 15);
    
            // Removing an item
            inventory.removeItemById(103);
    
            // Displaying total inventory value
            double totalValue = inventory.calculateTotalValue();
            System.out.println("Total Inventory Value: $" + totalValue);
    
            // Sorting inventory by Item Name
            inventory.sortInventory("name", true);
            System.out.println("Sorted Inventory by Item Name:");
            inventory.displayInventory();
        }
}