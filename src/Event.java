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
        while (haveSword == false) {
            System.out.println("testing sword");
            System.out.println("You see a sword. Would you like to take it?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int swordAnswer = userInput.nextInt();
            if (swordAnswer == 1) {
                player.addItemToInventory("Sword", "A sharp and shiny sword");
                haveSword = true;
            } else if (swordAnswer == 2) {
                System.out.println("You left the sword where it lay.");
            }
        }
    }

    private void handleRiver(Player player) {
        System.out.println("testing river");
    }
    private void handleCottage(Player player) {
        System.out.println("testing cottage");
    }
    private void handleSpikeTrap(Player player) {
        System.out.println("testing spikes");
    }
    private void handleForest(Player player) {
        System.out.println("testing forest"); }
    private void handleStartLocation(Player player) {
        System.out.println("testing start location");
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
