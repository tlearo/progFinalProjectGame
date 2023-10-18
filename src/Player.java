import java.util.List;

public class Player {
    private int currentHealth;
    private int maxHealth;
    private String playerName;
    private int gold;
    private int xLocation;
    private int yLocation;
    private int attackDamage;
    private String playerClass;
    private Inventory inventory;

    public Player(String playerName, int maxHealth, int currentHealth, int attackDamage, int xLocation, int yLocation, String playerClass, int gold) {
        this.playerName = playerName;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.attackDamage = attackDamage;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.inventory = new Inventory();
        this.playerClass = playerClass;
        this.gold = gold;
    }
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

    public void addItemToInventory(String itemName, String itemDescription) {
        inventory.addItem(itemName, itemDescription,0);
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

    public void healPlayer(int healthPotion) {
        if (this.currentHealth + healthPotion > this.maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth += healthPotion;
        }
    }

    public void printInventory() {
        List<Inventory.Item> items = inventory.getItems();
        System.out.println("\nInventory:");
        System.out.println("----------");
        for (Inventory.Item item : items) {
            System.out.println(item.getName() + " - " + item.getDescription()+"\n");
        }
    }

}

