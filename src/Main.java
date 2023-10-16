import java.util.Scanner;
import java.util.Random;
public class Main{
    public static void main(String[] args) {
        gameMap gameMap = new gameMap();
        Scanner userInput = new Scanner(System.in);
        Random random = new Random();
        boolean nameSet = false;

        // Getting player name
        String playerName;
        do {
            System.out.println("Please enter your name, Adventurer!");
            playerName = userInput.next();
            System.out.println("Your name is " + playerName + ", correct?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int nameConfirm = readInt("-> ", 2);
            if (nameConfirm == 1)
                nameSet = true;
        } while (!nameSet);

        // Creating character
        Player player = new Player(playerName, 100, 100, 10, 1, 2);
        Player evilFairy = new Player("Evil Fairy", 150, 150, 8, 0, 0);
        Player suitor = new Player("Suitor", 80, 80, 5, 3, 4);
        Player troll = new Player("Troll", 200, 200, 8, 4, 1);


        //Moving switch statement
        while (true) {
            gameMap.printMap(player);
            Display.name(player);
            Display.health(player);
            Display.attack(player);
            Display.location(player);
            System.out.println("Where would you like to move? (N/E/S/W): ");
            String move = userInput.next();
            boolean invalidMove = false;
            switch (move) {
                case "n":
                    if (player.getXLocation() > 0) {
                        player.setXLocation(player.getXLocation() - 1);
                        clearScreen();
                    } else {
                        invalidMove = true;
                        clearScreen();
                        System.out.println("The path is too treacherous that way...");
                    }
                    break;
                case "w":
                    if (player.getYLocation() > 0) {
                        player.setYLocation(player.getYLocation() - 1);
                        clearScreen();
                    } else {
                        invalidMove = true;
                        clearScreen();
                        System.out.println("The path is too treacherous that way...");
                    }
                    break;
                case "s":
                    if (player.getXLocation() < gameMap.mapSize - 1) {
                        player.setXLocation(player.getXLocation() + 1);
                        clearScreen();
                    } else {
                        invalidMove = true;
                        clearScreen();
                        System.out.println("The path is too treacherous that way...");
                    }
                    break;
                case "e":
                    if (player.getYLocation() < gameMap.mapSize - 1) {
                        player.setYLocation(player.getYLocation() + 1);
                        clearScreen();
                    } else {
                        invalidMove = true;
                        clearScreen();
                        System.out.println("The path is too treacherous that way...");
                    }
                    break;
                default:
                    clearScreen();
                    System.out.println("The atmosphere must be getting to you! You can only enter N/E/S/W");
            }
        }
    }
    static void clearScreen(){
        for(int i=1; i<=10; i++) {
            System.out.println("");
        }
    }

    public static int readInt(String prompt, int userChoices){
        Scanner userInput = new Scanner(System.in);
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(userInput.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Please enter a number!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }
}