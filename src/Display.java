//What is displayed underneath the map
public class Display {
    //Print Player Name
    public static void name(Player player) {

        System.out.println("Name: " + player.getPlayerName());
    }

    //Print Player Health
    public static void health(Player player) {
        System.out.println("Health: " + player.getCurrentHealth() + " / " + player.getMaxHealth());
    }

    //Print Player Attack
    public static void attack(Player player) {

        System.out.println("Attack Power: " + player.getAttackDamage());
    }

    //Print Player location
    public static void location(Player player) {
        System.out.println("Location: X" + player.getYLocation() + "-Y" + player.getXLocation());
    }

    public static void playerClass(Player player) {
        System.out.println("Class: "+player.getPlayerClass());
    }
    public static void gold(Player player) {
        System.out.println("Gold: "+player.getGold());
    }


    //OGRE
    public static void health(Enemy enemy) {
        System.out.println("Health: "+enemy.getCurrentHealth() + " / " + enemy.getMaxHealth());
    }

    public static void attack(Enemy enemy) {
        System.out.println("Attack: "+enemy.getAttackDamage());
    }
    public static void name(Enemy enemy) {
        System.out.println("Name: "+enemy.getEnemyName());
    }

//    public static void inventory(Inventory inventory) {
//
//        }
//    }
}