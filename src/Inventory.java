import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//Player Inventory Logic
    public class Inventory {

            private List<Item> items;
            private int maxSize = 10;

            public Inventory() {
                this.items = new ArrayList<>();
            }

            public boolean addItem(String name, String description) {
                    Item item = new Item(name, description);
                    items.add(item);
                    return true;
            }

            public boolean removeItem(Item item) {
                return items.remove(item);
            }

            public List<Item> getItems() {
                return items;
            }

            public class Item {
                private String name;
                private String description;

                public Item(String name, String description) {
                    this.name = name;
                    this.description = description;
                }
                //getters
                public String getName() {
                    return name;
                }

                public String getDescription() {
                    return description;
                }
            }

    }