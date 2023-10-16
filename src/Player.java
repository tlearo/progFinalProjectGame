import java.util.Scanner;
//Player Logic
public class Player{
    // Access identifiers
    private int currentHealth;
    private int maxHealth;
    private String playerName;
    private int xLocation;
    private int yLocation;
    private int attackDamage;

    // Constructors
    public Player(String playerName, int maxHealth, int currentHealth, int attackDamage, int xLocation, int yLocation) {
        this.playerName = playerName;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.attackDamage = attackDamage;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
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

    // Health increase/health potion
    public void healPlayer(int healthPotion) {
        if (this.currentHealth + healthPotion > this.maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth += healthPotion;
        }
    }
}