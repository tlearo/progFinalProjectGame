import java.util.List;

public class Player {
    private int currentHealth;     // Current health
    private int maxHealth;         // Maximum health
    private String playerName;      // Name of the player.
    private int gold;              // Amount of gold the player has.
    private int xLocation;         // X-coordinate of the player's location.
    private int yLocation;         // Y-coordinate of the player's location.
    private int attackDamage;      // Attack damage
    private String playerClass;    // The class or type of the player (e.g., warrior)
    private Inventory inventory;   // The player's inventory.

    public Player(String playerName, int maxHealth, int currentHealth, int attackDamage, int xLocation, int yLocation, String playerClass, int gold) {
        // Constructor for initializing player properties.
        this.playerName = playerName;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.attackDamage = attackDamage;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.inventory = new Inventory();  // Initialize the player's inventory.
        this.playerClass = playerClass;
        this.gold = gold;
    }

    // Getters and setters for various player properties.
    public int getGold() {
        return gold;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public void subtractGold(int amount) {
        gold -= amount;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
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

    public int getXLocation() {
        return xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }
    public String getPlayerClass() {
        return playerClass;
    }


    // Method for adding an item to the player's inventory.
    public void addItemToInventory(String itemName, String itemDescription) {
        inventory.addItem(itemName, itemDescription,0,0);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setXLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public void setYLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    // Method for healing the player with a health potion.
    public void healPlayer(int healthPotion) {
        if (this.currentHealth + healthPotion > this.maxHealth) {
            this.currentHealth = maxHealth;// Ensure the player's health doesn't exceed the maximum.
        } else {
            this.currentHealth += healthPotion;
        }
    }

    // Method for printing the player's inventory.
    public void printInventory() {
        List<Inventory.Item> items = inventory.getItems();
        System.out.println("\nInventory:");
        System.out.println("----------");
        for (Inventory.Item item : items) {
            System.out.println(item.getName() + " - " + item.getDescription()+"\n");
        }
    }

}




