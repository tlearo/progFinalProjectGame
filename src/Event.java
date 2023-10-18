import java.util.List;
import java.util.Scanner;
//Event Squares
public class Event {
    Scanner userInput = new Scanner(System.in); //implement scanner input
    private Player player; //assigning relationship to classes
    private Inventory inventory; //constructor

    public Event(Player player) {
        this.player = player;
    } //creating an instance of player for event

    //cases for gameMap
    public void handleEvent(char eventSymbol) throws InterruptedException {
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
            case '1':
                handleMarsh(player);
                break;
            case '2':
                handleWoods(player);
                break;
            case '3':
                handleSandyPlain(player);
                break;
            case '4':
                handleGreenFieldNorth(player);
                break;
            case '5':
                handleGreenFieldSouth(player);
                break;
            case '6':
                handleMountainEntrance(player);
                break;
            case '7':
                handleCraggyRocks(player);
                break;
            case '8':
                handleCliffEdge(player);
                break;
            case '9':
                handleMountainEast(player);
                break;
            default:
                handleDefaultEvent(player);
                break;
        }
    }

    //Fairy circle event
    private void handleFairyCircle(Player player) {
        System.out.println("testing Fairy circle");
    }

    //Boulder Sword event
    public boolean haveSword = false;
    private void handleGetSword(Player player) throws InterruptedException {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        while (haveSword == false) {
            System.out.println("\nYou see the hilt of a sword protruding from a crack in a large boulder.");
            Thread.sleep(1000);
            System.out.println("Would you like to pull it out?");
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
                Thread.sleep(1000);
                System.out.println("---Elven Sword was added to your inventory---");
                player.addItemToInventory("Elven Sword", "A sharp and shiny sword of excellent quality");
                Thread.sleep(500);
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
                Thread.sleep(500);
                break;
            }
        }
        if (haveSword == true) {
            System.out.println("\nBefore you stands the large boulder from whence you removed the sword.");
            Thread.sleep(1000);
        }
    }

    //Crossing river event
    private void handleRiver(Player player) {
        System.out.println("\nA swiftly flowing river surges in front of you.\nIt would be far too dangerous to try and swim across.");
    }

    //Cozy Cottage event
    private void handleCottage(Player player) throws InterruptedException {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        System.out.println("\nYou see a quaint, cozy cottage. It looks to be abandoned.");
        Thread.sleep(1000);
        System.out.println("Perhaps you could rest here to recover your strength.");
        Thread.sleep(1000);
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
            Thread.sleep(500);
        } else if (cottageAnswer == 2) {
            gameMap.printMap(player);
            Display.name(player);
            Display.playerClass(player);
            Display.health(player);
            Display.attack(player);
            Display.location(player);
            System.out.println("\nYou decide against resting in the cottage.");
            Thread.sleep(1000);
        }
    }

    //Spike trap event
    private void handleSpikeTrap(Player player) {
        System.out.println("testing spikes");
    }

    //Petalling forest event
    public Boolean haveFlower = false;
    private void handleForest(Player player) throws InterruptedException {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        while (haveFlower == false) {
            System.out.println("\nAs you get closer to the island, you see a field of thousands of beautiful flowers.");
            Thread.sleep(1000);
            System.out.println("You are reminded of the days where you and the Dragon went out on a picnic together in the fields.");
            Thread.sleep(1000);
            System.out.println("Would you like to make a flower bouquet for your lover?");
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
                System.out.println("\nYou carefully gather all her favourite flowers into a gorgeous bouquet");
                Thread.sleep(2000);
                System.out.println("---Flower Bouquet was added to your inventory---");
                player.addItemToInventory("Flower Bouquet", "Handpicked bouquet of the Dragons favourite flowers");
                haveFlower = true;
                break;
            } else if (swordAnswer == 2) {
                gameMap.printMap(player);
                Display.name(player);
                Display.playerClass(player);
                Display.health(player);
                Display.attack(player);
                Display.location(player);
                System.out.println("\nYou leave the flowers untouched, reminding yourself that you need to make one in order to win their heart back...");
                break;
            }
        }
        if (haveFlower == true) {
            System.out.println("\nYou carefully walk along the flower field, bouquet in hand, reminiscing the good old days...");
            Thread.sleep(1000);
        }
    }

    //Start location event
    private void handleStartLocation(Player player) {
        System.out.println("\nYou stand in a plain, grassy field.");
    }

    //Merchant's shop event
    private void handleShop(Player player) {
        // Create an instance of the inventory for the shop
        Inventory shopInventory = new Inventory();

        // Add items to the shop's inventory with costs
        shopInventory.addItem("Potion", "Restores some health", 20);
        shopInventory.addItem("Armor", "Provides extra defense", 50);

        // Display the shop's inventory
        List<Inventory.Item> shopItems = shopInventory.getItems();
        System.out.println("Welcome to the shop! Here's what's available for purchase:");

        for (int i = 0; i < shopItems.size(); i++) {
            Inventory.Item item = shopItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getDescription() + " (Cost: " + item.getCost() + " gold)");
        }

        // Allow the player to interact with the shop and buy items for gold
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Your Gold: " + player.getGold());
            int choice = Main.readInt("Enter the item number you want to buy (or 0 to exit):", shopItems.size());

            if (choice == 0) {
                System.out.println("Thank you for visiting the shop!");
                break;
            }

            if (choice > 0 && choice <= shopItems.size()) {
                Inventory.Item selectedItem = shopItems.get(choice - 1);
                int cost = selectedItem.getCost();

                if (player.getGold() >= cost) {
                    // Deduct the cost from the player's gold
                    player.subtractGold(cost);

                    // Add the purchased item to the player's inventory
                    player.addItemToInventory(selectedItem.getName(), selectedItem.getDescription());

                    // Remove the purchased item from the shop's inventory
                    shopInventory.removeItem(selectedItem);

                    System.out.println("You bought " + selectedItem.getName() + " for " + cost + " gold.");
                } else {
                    System.out.println("You don't have enough gold to buy this item.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid item number.");
            }
        }
    }



    //Suitor event
    private void handleSuitor(Player player) {
        System.out.println("testing suitor");
    }

    //Ogre event
    private void handleOgre(Player player) {
        System.out.println("testing ogre");
    }

    //Enchanted book cavern event
    private void handleCavern(Player player) {
        System.out.println("testing cavern");
    }

    //Dragon lover event
    private void handleDragon(Player player) {
        System.out.println("testing dragon");
    }

    //Quicksand event
    private void handleQuickSand(Player player) {
        System.out.println("testing quicksand"); }

    //Marsh non-event
    private void handleMarsh(Player player) {
        System.out.println("testing marsh"); }

    //Woods non-event
    private void handleWoods(Player player) {
        System.out.println("testing woods"); }

    //Sandyplain non-event
    private void handleSandyPlain(Player player) {
        System.out.println("testing sandy plain"); }

    //Greenfield north side non-event
    private void handleGreenFieldNorth(Player player) {
        System.out.println("testing green field north"); }

    //Greenfield south side non-event
    private void handleGreenFieldSouth(Player player) {
        System.out.println("testing "); }

    //Mountain entrance non-event
    private void handleMountainEntrance(Player player) {
        System.out.println("testing "); }

    //Craggy rocks non-event
    private void handleCraggyRocks(Player player) {
        System.out.println("testing craggy rocks"); }

    //Cliff edge non-event
    private void handleCliffEdge(Player player) {
        System.out.println("testing cliff edge"); }

    //Mountain east non-event, south direction is blocked
    private void handleMountainEast(Player player) {
        System.out.println("testing mountain east"); }

    //Default event, in case cases no catch
    private void handleDefaultEvent(Player player) {
        System.out.println("You've encountered an unknown area.");
    }
}
