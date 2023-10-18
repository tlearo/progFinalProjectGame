public class Enemy {
    private int currentHealth;
    private int maxHealth;
    private String enemyName;
    private int attackDamage;

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Enemy(String enemyName, int maxHealth, int currentHealth, int attackDamage) {
        this.enemyName = enemyName;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.attackDamage = attackDamage;
    }
}