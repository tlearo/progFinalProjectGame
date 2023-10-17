import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

//Player Logic
public class Player{
    // Access identifiers
    private int currentHealth;
    private int maxHealth;
    private String playerName;
    private int xLocation;
    private int yLocation;
    private int attackDamage;
    private Inventory inventory;
    @Override
    public String toString() {
        return "Inventory: " + inventory;
    }




//    public Player(String playerName, int maxHealth, int currentHealth, int attackDamage, int xLocation, int yLocation) {
//        this(playerName, maxHealth, currentHealth, attackDamage, xLocation, yLocation, new Inventory());
//    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    // Constructors
    public Player(String playerName, int maxHealth, int currentHealth, int attackDamage, int xLocation, int yLocation, Inventory inventory) {
        this.playerName = playerName;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.attackDamage = attackDamage;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.inventory = inventory;
    }
//    public Player(String playerName, int maxHealth, int currentHealth, int attackDamage, int xLocation, int yLocation) {
//        this(playerName, maxHealth, currentHealth, attackDamage, xLocation, yLocation);
//    }

    //Getters
    public void setPlayerName(String player) {
        playerName = player;
    }
    public String getPlayerName() {
        return playerName;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public int getAttackDamage() {
        return attackDamage;
    }

    public void setXLocation(int xLocation) {
        this.xLocation = xLocation;
    }
    public int getXLocation() {
        return xLocation;
    }

    public void setYLocation(int yLocation) {
        this.yLocation = yLocation;
    }
    public int getYLocation() {
        return yLocation;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // Health increase/health potion
    public void healPlayer(int healthPotion) {
        if (this.currentHealth + healthPotion > this.maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth += healthPotion;
        }
    }
    public class Inventory {
        private List<String> items;

        public Inventory() {
            items = new ArrayList<>();
        }

        public void addItem(String item) {
            items.add(item);
        }

        public List<String> getItems() {
            return items;
        }

        public void printInventory() {
            List<String> items = inventory.getItems();
            for (int i = 0; i < items.size(); i++) {
                System.out.println(items.get(i));
            }
        }
    }
}