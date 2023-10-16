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

            default:
                handleDefaultEvent(player);
                break;
        }
    }

    private void handleFairyCircle(Player player) {
        System.out.print("testing Fairy circle");
    }

    private void handleQuickSand(Player player) {
        // Implement your logic here
    }

    private void handleDefaultEvent(Player player) {
        System.out.println("You've encountered an unknown area.");
    }
}
