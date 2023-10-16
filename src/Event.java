import java.util.Scanner;
public class Event{
    public static void main(String[] args) {
        //Tamara, Monica and Millie Event.java
        Scanner myInput = new Scanner(System.in);
        String nl = "\n";
    }
    public static void handleEvent(Player player, char eventSymbol) {
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

    private static void handleFairyCircle(Player player) {
        System.out.print("testing Fairy circle");
    }

    private static void handleQuickSand(Player player) {

    }


    private static void handleDefaultEvent(Player player) {
        System.out.println("You've encountered an unknown area.");
    }
}