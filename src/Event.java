import java.util.List;
import java.util.Scanner;

public class Event {
    Scanner userInput = new Scanner(System.in);
    private Player player;
    private Inventory inventory;

    public Event(Player player) {
        this.player = player;
    }

    public void handleEvent(char eventSymbol) {
        switch (eventSymbol) {
            case 'F':
                handleFairyCircle(player);
                break;
            case 'Q':
                handleQuickSand(player);
                break;
            case 'B':
                handleGetSword(player);
                break;
            case '~':
                handleRiver(player);
                break;
            case 'C':
                handleCottage(player);
                break;
            case 'S':
                handleSpikeTrap(player);
                break;
            case '%':
                handleForest(player);
                break;
            case 'X':
                handleStartLocation(player);
                break;
            case '^':
                handleMountain(player);
                break;
            case '$':
                handleShop(player);
                break;
            case '@':
                handleSuitor(player);
                break;
            case '!':
                handleOgre(player);
                break;
            case 'E':
                handleCavern(player);
                break;
            case 'D':
                handleDragon(player);
                break;
            default:
                handleDefaultEvent(player);
                break;
        }
    }

    private void handleFairyCircle(Player player) {
        System.out.println("testing Fairy circle");
    }

    public boolean haveSword = false;
    private void handleGetSword(Player player) {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        while (haveSword == false) {
            System.out.println("\nYou see the hilt of a sword protruding from a crack in a large boulder.\nWould you like to pull it out?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int swordAnswer = Main.readInt("", 2);
            if (swordAnswer == 1) {
                gameMap.printMap(player);
                Display.name(player);
                Display.playerClass(player);
                Display.health(player);
                Display.attack(player);
                Display.location(player);
                System.out.println("\nWith one swift, strong motion you free the sword from it's stone!");
                System.out.println("---Elven Sword was added to your inventory---");
                player.addItemToInventory("Elven Sword", "A sharp and shiny sword of excellent quality");
                haveSword = true;
                player.setAttackDamage(player.getAttackDamage()+10);
                break;
            } else if (swordAnswer == 2) {
                gameMap.printMap(player);
                Display.name(player);
                Display.playerClass(player);
                Display.health(player);
                Display.attack(player);
                Display.location(player);
                System.out.println("\nYou leave the sword where it lays.");
                break;
            }
        }
        if (haveSword == true) {
            System.out.println("\nBefore you stands the large boulder from whence you removed the sword.");
        }
    }

    private void handleRiver(Player player) {
        System.out.println("\nA swiftly flowing river surges in front of you.\nIt would be far too dangerous to try and swim across.");
    }
    private void handleCottage(Player player) {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        System.out.println("\nYou see a quaint, cozy cottage. It looks to be abandoned.\nPerhaps you could rest here to recover your strength.");
        System.out.println("\nWould you like to rest?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int cottageAnswer = Main.readInt("", 2);
        if (cottageAnswer == 1) {
            player.setCurrentHealth(player.getMaxHealth());
            gameMap.printMap(player);
            Display.name(player);
            Display.playerClass(player);
            Display.health(player);
            Display.attack(player);
            Display.location(player);
            System.out.println("\n---You are fully healed---");
        } else if (cottageAnswer == 2) {
            gameMap.printMap(player);
            Display.name(player);
            Display.playerClass(player);
            Display.health(player);
            Display.attack(player);
            Display.location(player);
            System.out.println("\nYou decide against resting in the cottage.");
        }
    }
    private void handleSpikeTrap(Player player) {
        System.out.println("testing spikes");
    }
    private void handleForest(Player player) {
        System.out.println("testing forest"); }
    private void handleStartLocation(Player player) {
        System.out.println("\nYou stand in a plain, grassy field.");
    }
    private void handleMountain(Player player) {
        System.out.println("testing mountain");
    }
    private void handleShop(Player player) {
        System.out.println("testing shop");
    }
    private void handleSuitor(Player player) {
        System.out.println("testing suitor");
    }
    private void handleOgre(Player player) {
        System.out.println("testing ogre");
    }
    private void handleCavern(Player player) {
        System.out.println("testing cavern");
    }
    private void handleDragon(Player player) {
        System.out.println("testing dragon");
    }
    private void handleQuickSand(Player player) {
        System.out.println("testing quicksand"); }
    private void handleDefaultEvent(Player player) {
        System.out.println("You've encountered an unknown area.");
    }
}
