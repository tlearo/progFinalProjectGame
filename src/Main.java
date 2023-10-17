import java.util.Scanner;
import java.util.Random;

public class Main{
    private static Player player;
    public static void main(String[] args) throws InterruptedException {
        gameMap gameMap = new gameMap(); //initialising gameMap
        Scanner userInput = new Scanner(System.in); //implementing new scanner
        Random random = new Random(); //random class
        boolean nameSet = false;
        boolean classSet = false;
        Inventory inventory = new Inventory(); //Initialising inventory

        //Start Introduction
//        StoryLore.Introduction();

        // Getting player name
        String playerName;
        String playerClass = "Class";
        do {
            System.out.println("Please enter your name, Adventurer!");
            playerName = userInput.next();
            System.out.println("Your name is " + playerName + ", correct?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int nameConfirm = readInt("", 2);
            if (nameConfirm == 1)
                nameSet = true;
        } while (!nameSet);

        //Choosing your class
        int currentHealth = 100;
        int maxHealth = 100;
        int attackDamage = 10;
        do {
            System.out.println("What kind of adventurer are you?");
            System.out.println("1. Guardian (High health, low attack)");
            System.out.println("2. Assassin (Low health, high attack");
            System.out.println("3. Warrior (Average health, average attack)");
            int chooseClass = readInt("", 3);
            if(chooseClass == 1) {
                playerClass = "Guardian";
                currentHealth = 150;
                maxHealth = 150;
                attackDamage = 10;
                classSet = true;
            } else if (chooseClass == 2) {
                playerClass = "Assassin";
                currentHealth = 80;
                maxHealth = 80;
                attackDamage = 20;
                classSet = true;
            } else if (chooseClass == 3) {
                playerClass = "Warrior";
                currentHealth = 120;
                maxHealth = 120;
                attackDamage = 15;
                classSet = true;
        }

        } while (!classSet);

        // Creating character
        Inventory playerInventory = new Inventory();
        Player player = new Player(playerName, maxHealth, currentHealth, attackDamage, 1, 2, playerInventory);
        Event event = new Event(player);
//        Player evilFairy = new Player("Evil Fairy", 150, 150, 8, 0, 0, inventory);
//        Player suitor = new Player("Suitor", 80, 80, 5, 3, 4, inventory);
//        Player troll = new Player("Troll", 200, 200, 8, 4, 1, inventory);


        //Moving switch statement
        while (true) {
            char eventSymbol = gameMap.getEventSymbol(player.getXLocation(), player.getYLocation());
            event.handleEvent(eventSymbol);
            gameMap.printMap(player);
            Display.name(player);
            System.out.println("Class: "+playerClass);
            Display.health(player);
            Display.attack(player);
            Display.location(player);
            System.out.println("Where would you like to move? N/E/S/W (Type 'Q' to quit): ");
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
                case "q":
                    System.exit(0);
                default:
                    clearScreen();
                    System.out.println("The atmosphere must be getting to you! You can only enter N/E/S/W, or Q to quit!");
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