import java.util.List;
import java.util.Scanner;

public class Main {
    private static Player player;

    public static void main(String[] args) throws InterruptedException {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        Scanner userInput = new Scanner(System.in); // Implementing a new scanner
        boolean nameSet = false;
        boolean classSet = false;

        // Start Introduction
//         StoryLore.Introduction();

        // Getting player name
        String playerName;
        String playerClass = "Class";
        do {
            //user input
            System.out.println("Please enter your name, Adventurer!");
            playerName = userInput.next();
            System.out.println("Your name is " + playerName + ", correct?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int nameConfirm = readInt("", 1,2);
            if (nameConfirm == 1)
                nameSet = true;
        } while (!nameSet); //loop

        // Choosing your class
        int currentHealth = 100;
        int maxHealth = 100;
        int attackDamage = 10;
        do {
            System.out.println("\nWhat kind of adventurer are you?");
            System.out.println("1. Guardian (High health, low attack)");
            System.out.println("2. Assassin (Low health, high attack");
            System.out.println("3. Warrior (Average health, average attack)");
            //prompt user
            int chooseClass = readInt("", 1,3);
            System.out.println("");
            //GUARDIAN CLASS
            if (chooseClass == 1) {
                playerClass = "Guardian";
                currentHealth = 150;
                maxHealth = 150;
                attackDamage = 10;
                classSet = true;
                //ASSASSIN CLASS
            } else if (chooseClass == 2) {
                playerClass = "Assassin";
                currentHealth = 80;
                maxHealth = 80;
                attackDamage = 20;
                classSet = true;
                //WARRIOR CLASS
            } else if (chooseClass == 3) {
                playerClass = "Warrior";
                currentHealth = 120;
                maxHealth = 120;
                attackDamage = 15;
                classSet = true;
            }

        } while (!classSet); //loop

        Thread.sleep(500);
        StoryLore.Separator(5);

        // Creating a character
        Player player = new Player(playerName, maxHealth, currentHealth, attackDamage, 1, 2, playerClass, 50);
        Event event = new Event(player);


        //While player is alive
        while (player.getCurrentHealth() > 0) {
            //get location and display
            char eventSymbol = gameMap.getEventSymbol(player.getXLocation(), player.getYLocation());
            gameMap.printMap(player);
            System.out.println("");
            Display.name(player);
            Display.playerClass(player);
            Display.health(player);
            Display.attack(player);
            Display.gold(player);
            Display.location(player);
            player.printInventory();
            event.handleEvent(eventSymbol);
            System.out.println("\nWhere would you like to move? W/A/S/D (Type 'Q' to quit): ");
            String move = userInput.next().toLowerCase();
            //MOVING LOGIC
            boolean invalidMove = false;
            switch (move) {
                //NORTH
                case "w":
                    // Handle the player's movement and events, cannot go north
                    if (eventSymbol == 'D' || eventSymbol == 'E') {
                        System.out.println("\nYou can't go that way!\n");
                        Thread.sleep(1500);
                        break;
                    }
                    if (player.getXLocation() > 0) {
                        player.setXLocation(player.getXLocation() - 1);
                    } else {
                        invalidMove = true;
                        System.out.println("\nThe path is too treacherous that way...\n");
                        Thread.sleep(1500);
                    }
                    break;
                    //WEST
                case "a":
                    // Handle the player's movement and events, cannot go west, & river logic
                    if (eventSymbol == '7' || eventSymbol == '@' || ((eventSymbol == '~' && !event.hasBoat) || (eventSymbol == '&' && !event.hasBoat))) {
                        System.out.println("\nYou can't go that way!\n");
                        Thread.sleep(1500);
                        break;
                    }
                    if (player.getYLocation() > 0) {
                        player.setYLocation(player.getYLocation() - 1);
                    } else {
                        invalidMove = true;
                        System.out.println("\nThe path is too treacherous that way...\n");
                        Thread.sleep(1500);
                    }
                    break;
                    //SOUTH
                case "s":
                    // Handle the player's movement and events, cannot go south, & river logic
                    if ((eventSymbol == '~' && !event.hasBoat) || (eventSymbol == '&' && !event.hasBoat) || eventSymbol == 'E' || eventSymbol == '9') {
                        System.out.println("\nYou can't go that way!\n");
                        Thread.sleep(1500);
                        break;
                    }
                    if (eventSymbol != '~' && eventSymbol != '&') {
                        if (player.getXLocation() < gameMap.mapSize - 1) {
                            player.setXLocation(player.getXLocation() + 1);
                        } else {
                            invalidMove = true;
                            System.out.println("\nThe path is too treacherous that way...\n");
                            Thread.sleep(1500);
                        }
                        break;
                    } else if ((eventSymbol != '&' || eventSymbol != '~') && event.hasBoat && player.getXLocation() > 0) {
                        player.setXLocation(player.getXLocation() + 1);
                        break;
                }

                    if (player.getXLocation() < gameMap.mapSize - 1) {
                        player.setXLocation(player.getXLocation() + 1);
                    } else {
                        invalidMove = true;
                        System.out.println("\nThe path is too treacherous that way...\n");
                        Thread.sleep(1500);
                    }
                    break;
                    //EAST
                case "d":
                    // Handle the player's movement and events, cannot go east, river logic
                    if ((eventSymbol == '~' && !event.hasBoat) || eventSymbol == 'E' || eventSymbol == '4' || eventSymbol == '&' || (eventSymbol == '@' && !event.defeatSuitor)) {
                        if ((eventSymbol == '@' && !event.defeatSuitor)) {
                            System.out.println("\nYou need to defeat the suitor before you go this way!\n");
                            Thread.sleep(1500);
                        } else {
                            System.out.println("\nYou can't go that way!\n");
                            Thread.sleep(1500);
                        }
                        break;
                    }
                    if (player.getYLocation() < gameMap.mapSize - 1) {
                        player.setYLocation(player.getYLocation() + 1);
                    } else {
                        invalidMove = true;
                        System.out.println("\nThe path is too treacherous that way...\n");
                        Thread.sleep(1500);
                    }
                    break;
                    //quit
                case "q":
                    System.exit(0);
                    //else
                default:
                    if (player.getCurrentHealth() > 0) {
                        System.out.println("\nThe atmosphere must be getting to you! You can only enter W/A/S/D, or Q to quit!\n");
                        Thread.sleep(1500);
                    }
            }
            //call player inventory
            Inventory playerInventory = player.getInventory();
        }
    }

    // Define a method for using a health potion
    public static void useHealthPotion(Player player) throws InterruptedException {
        // Check if the player has a health potion and if they want to use it
        Inventory playerInventory = player.getInventory();
        boolean hasHealthPotion = playerInventory.getItems().stream().anyMatch(item -> item.getName().equals("Potion")); //need potion in inventory
        Scanner userInput = new Scanner(System.in); // Implementing a new scanner

        //DEAD PLAYER LOGIC
        if (player.getCurrentHealth() <= 0) {
            //has health potion
            if (hasHealthPotion) {
                //prompt user
                System.out.println("\nYou drop to your knees, on the verge of death. You remember that you have a health potion in your bag.");
                Thread.sleep(1000);
                System.out.println("Do you want to drink it?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int potionConfirm = readInt("", 1, 2);
                //yes
                if (potionConfirm == 1) {
                    List<Inventory.Item> items = playerInventory.getItems(); //get inventory
                    for (Inventory.Item item : items) { //when inventory has potion item
                        if (item.getName().equals("Potion")) {
                            player.healPlayer(item.getHp()); //how much hp is recovered
                            playerInventory.removeItem(item); //remove item
                            System.out.println("\nYou drank the health potion and gained " + item.getHp() + " health points. Your health was restored to " + player.getCurrentHealth() + "/" + player.getMaxHealth()); //set to max
                            break; // You should exit the loop here
                        }
                    }
                    //no
                } else {
                    System.out.println("You have died! Game over.");
                    Thread.sleep(1500);
                    System.exit(0);
                }
            }
        }
    }
    // Define a method to clear the screen
    static void clearScreen() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("");
        }
    }

    // Define a method to read an integer input within a specified range
    public static int readInt(String prompt, int min, int max) throws InterruptedException {
        // Read an integer input from the user within the specified range
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean isValid = false;

        do {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice >= min && choice <= max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid option. Please enter a valid choice.");
                    Thread.sleep(1500);
                }
            } else {
                input.next(); // Clear the invalid input
                System.out.println("Invalid input. Please enter a number.");
                Thread.sleep(1500);
            }
        } while (!isValid);

        return choice;
    }
}

