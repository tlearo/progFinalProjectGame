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
            System.out.println("Please enter your name, Adventurer!");
            playerName = userInput.next();
            System.out.println("Your name is " + playerName + ", correct?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int nameConfirm = readInt("", 1,2);
            if (nameConfirm == 1)
                nameSet = true;
        } while (!nameSet);

        // Choosing your class
        int currentHealth = 100;
        int maxHealth = 100;
        int attackDamage = 10;
        do {
            System.out.println("\nWhat kind of adventurer are you?");
            System.out.println("1. Guardian (High health, low attack)");
            System.out.println("2. Assassin (Low health, high attack");
            System.out.println("3. Warrior (Average health, average attack)");
            int chooseClass = readInt("", 1,3);
            System.out.println("");
            if (chooseClass == 1) {
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

        Thread.sleep(500);
        StoryLore.Separator(5);

        // Creating a character
        Player player = new Player(playerName, maxHealth, currentHealth, attackDamage, 1, 2, playerClass, 50);
        Event event = new Event(player);


        // Moving switch statement
        while (player.getCurrentHealth() > 0) {
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
            boolean invalidMove = false;
            switch (move) {
                case "w":
                    // Handle the player's movement and events
                    if (eventSymbol == 'D' || eventSymbol == 'E') {
                        System.out.println("\nYou can't go that way!\n");
                        break;
                    }
                    if (player.getXLocation() > 0) {
                        player.setXLocation(player.getXLocation() - 1);
                    } else {
                        invalidMove = true;
                        System.out.println("\nThe path is too treacherous that way...\n");
                    }
                    break;
                case "a":
                    // Handle the player's movement and events
                    if (eventSymbol == '7' || eventSymbol == '@' || ((eventSymbol == '~' && !event.hasBoat) || (eventSymbol == '&' && !event.hasBoat))) {
                        System.out.println("\nYou can't go that way!\n");
                        break;
                    }
                    if (player.getYLocation() > 0) {
                        player.setYLocation(player.getYLocation() - 1);
                    } else {
                        invalidMove = true;
                        System.out.println("\nThe path is too treacherous that way...\n");
                    }
                    break;

                case "s":
                    // Handle the player's movement and events
                    if ((eventSymbol == '~' && !event.hasBoat) || (eventSymbol == '&' && !event.hasBoat) || eventSymbol == 'E' || eventSymbol == '9') {
                        System.out.println("\nYou can't go that way!\n");
                        break;
                    }
                    if (eventSymbol != '~' && eventSymbol != '&') {
                        if (player.getXLocation() < gameMap.mapSize - 1) {
                            player.setXLocation(player.getXLocation() + 1);
                        } else {
                            invalidMove = true;
                            System.out.println("\nThe path is too treacherous that way...\n");
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
                    }
                    break;
                case "d":
                    // Handle the player's movement and events
                    if ((eventSymbol == '~' && !event.hasBoat) || eventSymbol == 'E' || eventSymbol == '4' || eventSymbol == '&' || (eventSymbol == '@' && !event.defeatSuitor)) {
                        if ((eventSymbol == '@' && !event.defeatSuitor)) {
                            System.out.println("\nYou need to defeat the suitor before you go this way!\n");
                        } else {
                            System.out.println("\nYou can't go that way!\n");
                        }
                        break;
                    }
                    if (player.getYLocation() < gameMap.mapSize - 1) {
                        player.setYLocation(player.getYLocation() + 1);
                    } else {
                        invalidMove = true;
                        System.out.println("\nThe path is too treacherous that way...\n");
                    }
                    break;
                case "q":
                    System.exit(0);
                default:
                    if (player.getCurrentHealth() > 0) {
                        System.out.println("\nThe atmosphere must be getting to you! You can only enter W/A/S/D, or Q to quit!\n");
                    }
            }
            Inventory playerInventory = player.getInventory();
        }
    }

    // Define a method for using a health potion
    public static void useHealthPotion(Player player) {
        // Check if the player has a health potion and if they want to use it
        Inventory playerInventory = player.getInventory();
        boolean hasHealthPotion = playerInventory.getItems().stream().anyMatch(item -> item.getName().equals("Potion"));
        Scanner userInput = new Scanner(System.in); // Implementing a new scanner

        if (player.getCurrentHealth() <= 0) {
            if (hasHealthPotion) {
                System.out.println("\nYou drop to your knees, on the verge of death. You remember that you have a health potion in your bag. Do you want to drink it?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int potionConfirm = readInt("", 1, 2);
                if (potionConfirm == 1) {
                    List<Inventory.Item> items = playerInventory.getItems();
                    for (Inventory.Item item : items) {
                        if (item.getName().equals("Potion")) {
                            player.healPlayer(item.getHp());
                            playerInventory.removeItem(item);
                            System.out.println("\nYou drank the health potion and gained " + item.getHp() + " health points. Your health was restored to " + player.getCurrentHealth() + "/" + player.getMaxHealth());
                            break; // You should exit the loop here
                        }
                    }
                } else {
                    System.out.println("You have died! Game over.");
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
    public static int readInt(String prompt, int min, int max) {
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
                }
            } else {
                input.next(); // Clear the invalid input
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!isValid);

        return choice;
    }
}

