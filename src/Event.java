import java.util.List;
import java.util.Scanner;

public class Event {
    private Player player;

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
        inventory.addItem("Extra Item", "Description for Extra Item");
    }
    private void handleGetSword(Player player) {
        System.out.println("testing sword");
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
