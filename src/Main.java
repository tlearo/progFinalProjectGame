import java.util.Scanner;
import java.util.Random;
public class Main{
    public static void main(String[] args) {
        gameMap gameMap = new gameMap();
        Scanner userInput = new Scanner(System.in);
        Random random = new Random();

        // Creating character
        Player player = new Player("Millie", 100, 100, 10, 1, 2);
        Player evilFairy = new Player("Evil Fairy", 150, 150, 8, 0, 0);
        Player suitor = new Player("Suitor", 80, 80, 5, 3, 4);
        Player troll = new Player("Troll", 200, 200, 8, 4, 1);

        //Moving switch statement
        while(true) {
            clearScreen();
            gameMap.printMap(player);
            System.out.println("Health: " + player.getCurrentHealth());
            System.out.println("Attack Power: " + player.getAttackDamage());
            System.out.println("Where would you like to move? (N/E/S/W): ");
            String move = userInput.next();
            boolean invalidMove = false;
            switch(move) {
                case "n":
                    if(player.getXLocation() > 0)
                        player.setXLocation(player.getXLocation()-1);
                    else {
                        invalidMove = true;
                        System.out.println("The path is too treacherous that way...");
                    }
                    break;
                case "w":
                    if(player.getYLocation() > 0)
                        player.setYLocation(player.getYLocation()-1);
                    else {
                        invalidMove = true;
                        System.out.println("The path is too treacherous that way...");
                    }
                    break;
                case "s":
                    if(player.getXLocation() < gameMap.mapSize -1)
                        player.setXLocation(player.getXLocation()+1);
                    else {
                        invalidMove = true;
                        System.out.println("The path is too treacherous that way...");
                    }
                    break;
                case "e":
                    if(player.getYLocation() < gameMap.mapSize -1)
                        player.setYLocation(player.getYLocation()+1);
                    else {
                        invalidMove = true;
                        System.out.println("The path is too treacherous that way...");
                    }
                    break;
            }
        }
    }
    static void clearScreen(){
        for(int i=1; i<=10; i++) {
            System.out.println("");
        }
    }
}