import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public class Item {
        private String name;
        private String description;
        private int cost;
        private int hp;
        public Item(String name, String description, int cost,int hp) {
            this.name = name;
            this.description = description;
            this.cost = cost;
            this.hp = hp;
        }
        public Item(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public int getHp() {
            return hp;
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

    public boolean addItem(String name, String description, int cost, int hp) {
        Item item = new Item(name, description, cost, hp);
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

