public class Display {
    public static void name(Player player) {
        System.out.println("Name: " + player.getPlayerName());
    }
    public static void health(Player player) {
        System.out.println("Health: " + player.getCurrentHealth() + " / " + player.getMaxHealth());
    }
    public static void attack(Player player) {
        System.out.println("Attack Power: " + player.getAttackDamage());
    }
    public static void location(Player player) {
        System.out.println("Location: X" + player.getXLocation() + "-Y" + player.getYLocation());
    }
}