import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public class Item {
        private String name;
        private String description;
        private int cost;
        public Item(String name, String description, int cost) {
            this.name = name;
            this.description = description;
            this.cost = cost;
        }
        public Item(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getCost() {
            return cost;
        }
    }

    private List<Item> items;
    private int maxSize = 10;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(String name, String description, int cost) {
        Item item = new Item(name, description, cost);
        items.add(item);
        return true;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
