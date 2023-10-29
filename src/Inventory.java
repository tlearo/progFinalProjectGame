import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public class Item {
        private String name; // The name of the item.
        private String description; // A description of the item.
        private int cost;  // The cost or value of the item.
        private int hp;  // Hit points (health) the item can restore (if applicable).

        // Constructor for an item with a cost and hp.
        public Item(String name, String description, int cost,int hp) {
            this.name = name;
            this.description = description;
            this.cost = cost;
            this.hp = hp;
        }

        // Constructor for an item without a cost or hp.
        public Item(String name, String description) {
            this.name = name;
            this.description = description;
        }

        // Get the item's hit points value.
        public int getHp() { return hp; }

        // Get the item's name.
        public String getName() { return name; }

        // Get the item's description.
        public String getDescription() { return description; }

        // Get the item's cost or value.
        public int getCost() { return cost; }
    }

    private List<Item> items;// A list to store items in the inventory.
    private int maxSize = 10;// The maximum number of items the inventory can hold.

    public Inventory() {
        this.items = new ArrayList<>();// Initialize the inventory with an empty list of items.
    }

    // Method to add an item with a cost and hp to the inventory.
    public boolean addItem(String name, String description, int cost, int hp) {
        Item item = new Item(name, description, cost, hp);// Create a new item.
        items.add(item);// Add the item to the inventory.
        return true;// Return true to indicate successful addition.
    }

    // Method to add an item without a cost or hp to the inventory.
    public boolean addItem(String name, String description) {
        Item item = new Item(name, description);// Create a new item.
        items.add(item);// Add the item to the inventory.
        return true;// Return true to indicate successful addition.
    }

    // Method to remove an item from the inventory.
    public boolean removeItem(Item item) {
        return items.remove(item);// Remove the specified item and return true if successful.
    }

    // Method to get a list of all items in the inventory.
    public List<Item> getItems() {
        return items;// Return the list of items in the inventory.
    }
}

