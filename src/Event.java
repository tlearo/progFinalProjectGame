import java.util.List;
import java.util.Scanner;

//Event Squares
public class Event {
    Scanner userInput = new Scanner(System.in);  // Initialize a Scanner object for user input
    private Player player; // Declare a private instance variable for the Player class
    private Enemy enemy; // Declare a private instance variable for the Enemy class
    private Inventory inventory; // Declare a private instance variable for the Inventory class

    public boolean hasBoat; // Declare a boolean variable to track whether the player has a boat
    gameMap gameMap = new gameMap(); // Initialize a gameMap object

    public Event(Player player) {
        this.player = player; // Initialize the Event object with a Player instance
        this.inventory = player.getInventory(); // Assign the player's inventory to the Event's inventory
    } //creating an instance of player for event

    // Handle different events on the game map based on event symbols
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
            case '&':
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
                break;
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
                handleGreenFieldSouth(player);
                break;
            case '5':
                handleGreenFieldNorth(player);
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

    // Method to display player information
    public static void displayPlayerInfo(Player player) {
        gameMap gameMap = new gameMap();
        gameMap.printMap(player);
        Display.name(player);
        Display.playerClass(player);
        Display.health(player);
        Display.attack(player);
        Display.gold(player);
        Display.location(player);
        player.printInventory();
    }

    public int randomAttackPower; // Declare a variable to store random attack power

    // Random Number Generator method
    public int RandomNumber() {
        int minDamage = 0;
        int maxDamage = 30;
        randomAttackPower = (int) (Math.floor(Math.random() * 31));
        return randomAttackPower;
    }

    //Battle stats method
    public void BattleStats(Enemy enemy) {
        Display.name(player);
        Display.health(player);
        Display.attack(player);
        System.out.println("-----------------");
        Display.name(enemy);
        Display.health(enemy);
    }

    // Method to handle a battle with an enemy
    public boolean wonFight = false;

    public void battle(Enemy enemy) throws InterruptedException {
        //Attack enemy and what play damage applied
        System.out.println("\nYou attacked the " + enemy.getEnemyName() + " and did " + player.getAttackDamage() + " damage!");

        enemy.setCurrentHealth(enemy.getCurrentHealth() - player.getAttackDamage());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //when enemy is dead
        if (enemy.getCurrentHealth() < 1) {
            StoryLore.Separator(5);
            displayPlayerInfo(player);
            System.out.println("\nThe " + enemy.getEnemyName() + " fell to its knees as you attack them in one big blow");
            System.out.println("\nAfter your valiant efforts, you have won the battle!");
            Thread.sleep(1000);
            System.out.println("\nYou scour their body and find 100 gold!");
            Thread.sleep(1000);
            player.addGold(100);
            //winning fight becomes true
            wonFight = true;
        }
        // when enemy is alive
        if (enemy.getCurrentHealth() > 0) {
            int EnemyDamage;
            //enemy damage with a bound of 10
            EnemyDamage = (enemy.getAttackDamage() + (new java.util.Random().nextInt(10)));
            System.out.println("\nThe " + enemy.getEnemyName() + " attacked for " + EnemyDamage + " damage!\n");
            player.setCurrentHealth(player.getCurrentHealth() - EnemyDamage);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BattleStats(enemy);
            //when player is dead
            if (player.getCurrentHealth() < 1) {
                //ability to use health potion
                Main.useHealthPotion(player);
                if (player.getCurrentHealth() > 0) {
                    StoryLore.Separator(5);
                    System.out.println("\nYou're too weak to continue the fight so you ran away!");
                    Thread.sleep(2000);
                }
                //else die if no health potion
                if (player.getCurrentHealth() <= 0) {
                    StoryLore.Separator(5);
                    System.out.println("\nYou lost the fight!");
                    Thread.sleep(1000);
                    System.out.println("\nYou have died! Game over.");
                    System.exit(0);
                }
                //when player is alive
            } else if (player.getCurrentHealth() > 0) {
                System.out.println("\nDo you want to keep attacking the " + enemy.getEnemyName() + "?");
                Thread.sleep(500);
                System.out.println("\n1. Attack\n2. Run");
                int ContinueFight = Main.readInt("", 1, 2);
                if (ContinueFight == 1) { //repeat
                    battle(enemy);
                } else if (ContinueFight == 2) { //run
                    StoryLore.Separator(5);
                    System.out.print("\nAs you continue to fight the " + enemy.getEnemyName() + ", you find yourself getting restless...");
                    Thread.sleep(1000);
                    System.out.print("\nYou decide its best not to continue fighting this " + enemy.getEnemyName() + " and you shall return when you are ready!\n");
                    Thread.sleep(1000);
                    displayPlayerInfo(player);
                }
            }
        }
    }

    //Fairy circle event
    public boolean firstVisitFairyCircle = true;

    private void handleFairyCircle(Player player) throws InterruptedException {
        int attackPower = RandomNumber();
        if (firstVisitFairyCircle) {
            StoryLore.Separator(5);
            // Create an enemy for the fairy queen
            Enemy enemy = new Enemy("Evil Fairy", 100, 100, attackPower);
            System.out.println("\nYou emerge out of the scrub into a grassy clearing.\n" +
                    "You see a large circle of red and white spotted mushrooms surrounding a small tree stump.");
            Thread.sleep(1000);
            System.out.println("Nestled within the stump is a beautiful ruby red gemstone! It's iridescent glow reminds you of the dragon's lovely eyes.\n" +
                    "You feel the strong urge to covet this gemstone!\n");
            Thread.sleep(1000);
            System.out.println("Do you enter the mushroom circle to take it?\n");
            Thread.sleep(500);
            //prompt user
            System.out.println("1. Enter");
            System.out.println("2. Leave");
            int enterCircle = Main.readInt("", 1, 2);
            //Enter circle, choice 1
            if (enterCircle == 1) {
                StoryLore.Separator(5);
                System.out.print("\nYou step over the line of mushrooms, but as soon as your foot touches \n" +
                        "the ground on the other side a swirl of flower petals and leaves rush upwards in front of you!");
                System.out.println("When the air clears, you see a beautiful fairy queen standing before you.\n" +
                        "'How dare you enter my circle without my permission! Leave or you shall die!'\n");
                Thread.sleep(500);
                //prompt user
                System.out.println("1. Attack");
                System.out.println("2. Run");
                int fairyFight = Main.readInt("", 1, 2);
                //enter fairy fight
                if (fairyFight == 1) {
                    StoryLore.Separator(5);
                    System.out.print("\nLETS GO TO BATTLE!\n\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //call Battle system
                    BattleStats(enemy);
                    battle(enemy);
                    //when enemy die
                    if (wonFight == true) {
                        Thread.sleep(1000);
                        StoryLore.Separator(5);
                        displayPlayerInfo(player);
                        System.out.print("\nYou step over the slain fairy queen, and grab the gemstone from within the stump.\n");
                        Thread.sleep(1000);
                        System.out.print("\n---Red Gemstone added to your inventory---\n");
                        Thread.sleep(2000);
                        player.getInventory().addItem("Red Gemstone", "A bright red shining ruby."); //add gem to inventory
                        //make false again
                        wonFight = false;
                        firstVisitFairyCircle = false;
                    }
                    //run away from fight
                } else if (fairyFight == 2) {
                    StoryLore.Separator(5);
                    System.out.print("\nYou run away from this horrifying fairy queen!");
                    Thread.sleep(1000);
                    displayPlayerInfo(player);
                }
                //run away from entering
            } else if (enterCircle == 2) {
                StoryLore.Separator(5);
                System.out.print("\nYou decide to give the mushroom circle a wide berth...\n");
                Thread.sleep(1000);
                displayPlayerInfo(player);
            }
            //not the first visit
        } else if (!firstVisitFairyCircle) {
            StoryLore.Separator(5);
            System.out.println("The slain body of the fairy queen lays before you, her sparkling blood staining the ground inside of the mushroom circle");
            Thread.sleep(1000);
            displayPlayerInfo(player);
        }
    }

    //Boulder Sword event
    public boolean haveSword = false;

    private void handleGetSword(Player player) throws InterruptedException {
        while (!haveSword) {
            StoryLore.Separator(5);
            System.out.println("\nYou see the hilt of a sword protruding from a crack in a large boulder.");
            Thread.sleep(1000);
            System.out.println("Would you like to pull it out?");
            Thread.sleep(500);
            //prompt user
            System.out.println("1. Yes");
            System.out.println("2. No");
            int swordAnswer = Main.readInt("", 1, 2);
            //when they take sword, add to inventory
            if (swordAnswer == 1) {
                StoryLore.Separator(5);
                displayPlayerInfo(player);
                System.out.println("\nWith one swift, strong motion you free the sword from it's stone!");
                Thread.sleep(1000);
                System.out.println("\n---Elven Sword was added to your inventory---");
                System.out.println("\nYour attack damage has increased by 10 points");
                player.addItemToInventory("Elven Sword", "A sharp and shiny sword of excellent quality"); //add sword to inventory
                Thread.sleep(500);
                haveSword = true;
                player.setAttackDamage(player.getAttackDamage() + 10);
                break;
                //when they dont
            } else if (swordAnswer == 2) {
                StoryLore.Separator(5);
                displayPlayerInfo(player);
                System.out.println("\nYou leave the sword where it lays.");
                Thread.sleep(500);
                break;
            }
        }
        //when you have sword
        if (haveSword == true) {
            StoryLore.Separator(5);
            System.out.println("\nBefore you stands the large boulder from whence you removed the sword.");
            Thread.sleep(1000);
        }
    }

    //Crossing river event
    private void handleRiver(Player player) throws InterruptedException {
        hasBoat = inventory.getItems().stream().anyMatch(item -> item.getName().equals("Boat")); //need boat to be in inventory
        if (hasBoat) {
            StoryLore.Separator(5);
            System.out.println("\nA swiftly flowing river surges in front of you...");
            Thread.sleep(1000);
            System.out.println("With the boat you purchased, you're able to travel across it!");
        } else {
            StoryLore.Separator(5);
            System.out.println("\nA swiftly flowing river surges in front of you.\n");
            Thread.sleep(1000);
            System.out.println("It would be far too dangerous to try and swim across. Perhaps a boat would help?");
        }
    }

    //Cozy Cottage event
    private void handleCottage(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nYou see a quaint, cozy cottage. It looks to be abandoned.");
        Thread.sleep(1000);
        System.out.println("Perhaps you could rest here to recover your strength.");
        Thread.sleep(1000);
        System.out.println("\nWould you like to rest?");
        Thread.sleep(500);
        //prompt user
        System.out.println("1. Yes");
        System.out.println("2. No");
        int cottageAnswer = Main.readInt("", 1, 2);
        //user want to rest, fill max health
        if (cottageAnswer == 1) {
            StoryLore.Separator(5);
            player.setCurrentHealth(player.getMaxHealth()); //setting player to max health
            displayPlayerInfo(player);
            System.out.println("\n---You are fully healed---");
            Thread.sleep(1000);
            //user doesnt
        } else if (cottageAnswer == 2) {
            StoryLore.Separator(5);
            displayPlayerInfo(player);
            System.out.println("\nYou decide against resting in the cottage.");
            Thread.sleep(1000);
        }
    }

    //Spike trap event
    public boolean enteredSpikeTrap = false;
    public boolean firstVisitSpikeTrap = true;

    private void handleSpikeTrap(Player player) throws InterruptedException {
        if (firstVisitSpikeTrap) {
            StoryLore.Separator(5);
            System.out.println("\nYou emerge into a clearing, in the middle of which lays a pile of forest debris.");
            Thread.sleep(1000);
            System.out.println("\nWhat do you do?\n");
            Thread.sleep(500);
            //prompt user
            System.out.println("1. Confidently walk across the debris");
            System.out.println("2. Avoid the debris");
            int spikeTrapAnswer = Main.readInt("", 1, 2);
            //they get hurt 20 dmg
            if (spikeTrapAnswer == 1) {
                StoryLore.Separator(5);
                System.out.println("\nYou stride across the debris without a care in the world.\n" +
                        "Suddenly, the ground below you gives out!");
                Thread.sleep(1000);
                System.out.println("You tumble downwards into a pit of sharpened spikes and take 20 damage!\n");
                player.setCurrentHealth(player.getCurrentHealth() - 20); //dmg 20 to player health
                enteredSpikeTrap = true;
                firstVisitSpikeTrap = false;
                Thread.sleep(1000);
                displayPlayerInfo(player);
                //when player is dead
                if (player.getCurrentHealth() < 1) {
                    //ability to use health potion
                    Main.useHealthPotion(player);
                    if (player.getCurrentHealth() > 0) {
                        StoryLore.Separator(5);
                        System.out.println("You manage to crawl out of the pit having learned your lesson regarding reckless behaviour.\n");
                        Thread.sleep(2000);
                    }
                    //else die if no health potion
                    if (player.getCurrentHealth() <= 0) {
                        StoryLore.Separator(5);
                        System.out.println("\nThe spikes were too sharp!");
                        Thread.sleep(1000);
                        System.out.println("\nYou have died! Game over.");
                        System.exit(0);
                    }
                }
            } else if (spikeTrapAnswer == 2) {
                StoryLore.Separator(5);
                displayPlayerInfo(player);
                System.out.println("Upon inspection you notice the debris is covering a spike trap!\n");
                Thread.sleep(500);
                System.out.println("You carefully sidle past it; it would've been embarrassing if you had fallen into it.\n");
                Thread.sleep(1000);
                enteredSpikeTrap = true;
                firstVisitSpikeTrap = false;
            }
        // for subsequent visits to the square
        } else if (!firstVisitSpikeTrap) {
            StoryLore.Separator(5);
            System.out.println("\nBefore you is a dangerous spike trap. You've dealt with this hazard before, so you carefully maneuver around it, avoiding harm.\n");
            Thread.sleep(500);
        }
    }

    //Petalling forest event
    public Boolean haveFlower = false;

    private void handleForest(Player player) throws InterruptedException {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        while (haveFlower == false) {
            StoryLore.Separator(5);
            System.out.println("\nAs you get closer to the island, you see a field of thousands of beautiful flowers.");
            Thread.sleep(1000);
            System.out.println("You are reminded of the days where you and the Dragon went out on a picnic together in the fields.");
            Thread.sleep(1000);
            System.out.println("Would you like to make a flower bouquet for your lover?");
            Thread.sleep(500);
            //prompt user
            System.out.println("1. Yes");
            System.out.println("2. No");
            int flowerAnswer = Main.readInt("", 1, 2);
            //get flower bouquet, put in inventory
            if (flowerAnswer == 1) {
                StoryLore.Separator(5);
                displayPlayerInfo(player);
                System.out.println("\nYou carefully gather all her favourite flowers into a gorgeous bouquet");
                Thread.sleep(1000);
                System.out.println("---Flower Bouquet was added to your inventory---");
                player.addItemToInventory("Flower Bouquet", "Handpicked bouquet of the Dragons favourite flowers"); //add flower to inventory
                Thread.sleep(500);
                haveFlower = true;
                break;
                //dont get flower
            } else if (flowerAnswer == 2) {
                StoryLore.Separator(5);
                displayPlayerInfo(player);
                System.out.println("\nYou leave the flowers untouched, reminding yourself that you need to make one in order to win their heart back...");
                Thread.sleep(1000);
                break;
            }
        }
        //when they have already visited
        if (haveFlower == true) {
            StoryLore.Separator(5);
            System.out.println("\nYou carefully walk along the flower field, bouquet in hand, reminiscing the good old days...");
            Thread.sleep(1000);
        }
    }

    //Start location event
    private void handleStartLocation(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("You walk past the poster that you saw when you entered the forest");
        Thread.sleep(1000);
        System.out.println("You remind yourself that you need to get the Dragons heart back...");
    }

    // Create an instance of the inventory for the shop (outside the method)
    Inventory shopInventory = new Inventory();

    public void handleShop(Player player) throws InterruptedException {
        // Add items to the shop's inventory with costs (you can do this once at initialization)
        if (shopInventory.getItems().isEmpty()) {
            shopInventory.addItem("Potion", "Heals you fully when your health drops to 0", 50, player.getMaxHealth()); // Set cost and max health here
            shopInventory.addItem("Armor", "Boosts your max health by 50 points", 50, 50);
            shopInventory.addItem("Boat", "Can be used to cross a flowing river", 100, 0);
        }

        // Display the shop's inventory
        StoryLore.Separator(5);
        List<Inventory.Item> shopItems = shopInventory.getItems();
        System.out.println("\nYou see a quaint little wooden building with a sign above the entrance which reads 'Geoffrey's Genuine Goods!'");
        Thread.sleep(1000);//wait
        System.out.println("You step through the doorway and a short man with a large grin on his face beckons you over to him.");
        Thread.sleep(1000);//wait
        System.out.println("'Welcome to my store adventurer! We have a number of excellent products for sale here, take a look to see if anything strikes your fancy!'");
        Thread.sleep(1000);
        System.out.println("\nHere's what's available for purchase:");
        Thread.sleep(500);

        //FOR loop for the menu prompt
        for (int i = 0; i < shopItems.size(); i++) {
            Inventory.Item item = shopItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getDescription() + " (Cost: " + item.getCost() + " gold)");
        }
        System.out.println("4. Leave the store");

        boolean inShop = true; // Flag to track if the player is in the shop

        while (inShop) {
            //prompt user
            System.out.println("What item number would you like to buy? 1/2/3 (Press 4 to leave the shop): ");
            Thread.sleep(1000);
            String choiceInput = userInput.next();

            //when they leave
            if (choiceInput.equals("4")) {
                Thread.sleep(500);
                System.out.println("\nThank you for visiting Geoffrey's Genuine Goods! Come on back any time!\n");
                Thread.sleep(1000);
                displayPlayerInfo(player);
                inShop = false; // Exit the shop loop
            } else {
                try {
                    int choice = Integer.parseInt(choiceInput);
                    if (choice > 0 && choice <= shopItems.size()) {
                        Inventory.Item selectedItem = shopItems.get(choice - 1);
                        int cost = selectedItem.getCost();
                        int hpGranted = selectedItem.getHp(); // Get HP granted by the item

                        if (player.getGold() >= cost) {
                            // Deduct the cost from the player's gold
                            player.subtractGold(cost);

                            if (choiceInput.equals("2")) {
                                // Update the player's health when buying Armor
                                player.setCurrentHealth(player.getCurrentHealth() + hpGranted);
                                player.setMaxHealth(player.getMaxHealth() + hpGranted);
                                player.getInventory().addItem(selectedItem.getName(), selectedItem.getDescription(), cost, hpGranted);
                                System.out.println("\nYou bought " + selectedItem.getName() + " for " + cost + " gold.\n");
                                Thread.sleep(500);
                                System.out.println("---" + selectedItem.getName() + " added to your inventory---");
                                Thread.sleep(500);
                                System.out.println("\nYour maximum health is increased by " + hpGranted + " HP.\n");
                                Thread.sleep(1000);
                                Display.health(player);
                                Display.gold(player);
                            } else {
                                // Add the purchased item to the player's inventory (e.g., Potion or Boat)
                                player.getInventory().addItem(selectedItem.getName(), selectedItem.getDescription(), cost, hpGranted);
                                System.out.println("\nYou bought " + selectedItem.getName() + " for " + cost + " gold.\n");
                                Thread.sleep(500);
                                System.out.println("---" + selectedItem.getName() + " added to your inventory---");
                                Thread.sleep(1000);
                                Display.gold(player);
                            }
                        } else {
                            System.out.println("\nYou don't have enough gold to buy this item.\n");
                            Thread.sleep(1000);
                        }
                    } else {
                        System.out.println("\nInvalid choice. Please enter a valid item number.\n");
                        Thread.sleep(1000);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input. Please enter a valid item number or 4 to exit.\n");
                    Thread.sleep(1000);
                }
            }
        }
    }

    //Ogre event
    public boolean firstVisitOgre = true;

    private void handleOgre(Player player) throws InterruptedException {
        //create enemy
        int attackPower = RandomNumber();
        if (firstVisitOgre = true) {
            Enemy enemy = new Enemy("Ogre", 200, 200, attackPower);
            StoryLore.Separator(5);
            System.out.println("\nYou step into a dusty clearing, the wind whips the dirt up around you momentarily obscuring your vision." +
                    "\nAfter the dust settles you see an enormous green Ogre standing before you. It towers over you, and it's eyes gleam with bloodlust.");
            Thread.sleep(1000);
            System.out.println("A greedy smile creeps across it's face, and then it lets out a bellowing roar!" +
                    "\n\nPrepare for battle, or run!");
            Thread.sleep(500);
            //prompt user
            System.out.println("1. Attack");
            System.out.println("2. Run");
            int ogreFight = Main.readInt("", 1, 2);
            if (ogreFight == 1) {
                //battle system
                StoryLore.Separator(5);
                System.out.print("\nLETS GO TO BATTLE!\n\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                BattleStats(enemy);
                battle(enemy);
                if (wonFight == true) {
                    StoryLore.Separator(5);
                    displayPlayerInfo(player);
                    System.out.print("\nWith all your might, you run towards the Ogre and slay him once and for all!");
                    Thread.sleep(1000);
                    System.out.print("Indenting the desert, the Ogre fell into the sand");
                    firstVisitOgre = false;
                    wonFight = false;
                }//else run
            } else if (ogreFight == 2) {
                StoryLore.Separator(5);
                System.out.print("\nHis roar gave you a fright and you decided not to take the fight this time...");
                Thread.sleep(1000);
                System.out.print("\nYou shall return when you are ready!");
                Thread.sleep(1000);
                displayPlayerInfo(player);
            }
        }
        //when they come back
        if(!firstVisitOgre) {
            StoryLore.Separator(5);
            System.out.println("\nA stench reaches into your nose as you walk past the slain Ogre \nYou continue walking through the desert.");
            Thread.sleep(1000);
        }
    }

    //Enchanted book cavern event
    public Boolean haveBook = false;

    private void handleCavern(Player player) throws InterruptedException {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        if (haveBook == false) {
            StoryLore.Separator(5);
            System.out.println("\nYou walk towards the dark dingy cave and stumble upon a library, illuminated by flowing wisps.");
            Thread.sleep(1000);
            System.out.println("Straight ahead you see a podium enclosing a ruined book. \nIt looks like the book that you threw when the dragon and you had an argument this one time...");
            Thread.sleep(1000);
            System.out.println("You want to grab it as; although it held a dark memory, the book has been intertwined in both of your lives and you feel as though the Dragon would appreciate it");
            Thread.sleep(1000);
            System.out.println("Before you reach for the book, your sense heightens and you feel a cold breeze blow in through the cave. \nIs there something waiting for you?");
            Thread.sleep(1000);
            System.out.println("\nWould you like to reach for the book?");
            Thread.sleep(500);
            //prompt user
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("3. Inspect the podium");
            int bookAnswer = Main.readInt("", 1, 3);
            //take book and dmg 20
            if (bookAnswer == 1) {
                StoryLore.Separator(5);
                System.out.println("\nYou grab the book off the podium and hear a trigger!");
                //take damage 20 from current health
                player.setCurrentHealth(player.getCurrentHealth() - 20);
                Thread.sleep(1000);
                System.out.println("OOF!");
                Thread.sleep(500);
                System.out.println("You have been hit with a hidden arrow and taken 20 damage\nThrough the pain, you have obtained the book!\n");
                player.addItemToInventory("Ruined Book", "The book that reminds you of your past relationship"); //add to book to inventory
                Thread.sleep(1000);
                System.out.println("---Ruined Book was added to your inventory---");
                Thread.sleep(1500);
                if (player.getCurrentHealth() < 1) {
                    //ability to use health potion
                    Main.useHealthPotion(player);
                    if (player.getCurrentHealth() > 0) {
                        StoryLore.Separator(5);
                        System.out.println("As you drink the health potion, you start to feel yourself become alive again!\n");
                        Thread.sleep(2000);
                    }
                    //else die if no health potion
                    if (player.getCurrentHealth() <= 0) {
                        StoryLore.Separator(5);
                        System.out.println("\nThe arrow shot right at your heart and you lost consciousness");
                        Thread.sleep(1000);
                        System.out.println("\nYou have died! Game over.");
                        System.exit(0);
                        player.addItemToInventory("Ruined Book", "The book that reminds you of your past relationship"); //add book to inventory
                        displayPlayerInfo(player);
                        System.out.println("---Ruined Book was added to your inventory---");
                        Thread.sleep(1000);
                        //they walk away
                    }
                }
                haveBook = true;
            }else if (bookAnswer == 2) {
                StoryLore.Separator(5);
                System.out.println("\nYou leave the book alone, feeling a sense of sadness wash over you.\nThe book would help win the Dragon's heart over...");
                Thread.sleep(1000);
                displayPlayerInfo(player);
                //inspect
            } else if (bookAnswer == 3) {
                StoryLore.Separator(5);
                System.out.println("\nAs you look closer into the podium, you realise the book is on top of a pressure plate.\nIf you had lifted the book, it would trigger a trap!");
                Thread.sleep(1000);
                System.out.println("You look around the cave some more to look for a replacement and see:\n- A slab of rock that seems to be the same size as the book \n- And a pile of dirt that has the potential to weight the same as the book\nthat you could replace the book with.");
                Thread.sleep(1000);
                System.out.println("\nWhich do you choose to replace the book with?");
                Thread.sleep(500);
                //prompt user
                System.out.println("1. A slab of rock");
                System.out.println("2. A pile of dirt");
                Thread.sleep(2000);
                int bookTrapAnswer = Main.readInt("", 1, 2);
                //rock gets book
                if (bookTrapAnswer == 1) {
                    StoryLore.Separator(5);
                    System.out.println("You grab the slab of rock and quickly lift the book to swiftly put the rock in replacement");
                    Thread.sleep(1000);
                    System.out.println("It worked and you have obtained the book!");
                    Thread.sleep(1500);
                    player.addItemToInventory("Ruined Book", "The book that reminds you of your past relationship"); //add to book to inventory
                    System.out.println("---Ruined Book was added to your inventory---");
                    displayPlayerInfo(player);
                    Thread.sleep(1000);
                    haveBook = true;
                    //get book and dmg
                } else if (bookTrapAnswer == 2) {
                    StoryLore.Separator(5);
                    displayPlayerInfo(player);
                    System.out.println("You grab a handful of dirt and quickly try to replace the book. \nAs you lift the ruined book, the handful of dirt is flowing out of your hand and it was not weighted enough to work as a replacement!");
                    Thread.sleep(1000);
                    System.out.println("OUCH!");
                    //take damage
                    player.setCurrentHealth(player.getCurrentHealth() - 20);
                    //when player is dead
                    if (player.getCurrentHealth() < 1) {
                        //ability to use health potion
                        Main.useHealthPotion(player);
                        if (player.getCurrentHealth() > 0) {
                            StoryLore.Separator(5);
                            System.out.println("As you drink the health potion, you start to feel yourself become alive again!\n");
                            Thread.sleep(2000);
                        }
                        //else die if no health potion
                        if (player.getCurrentHealth() <= 0) {
                            StoryLore.Separator(5);
                            System.out.println("\nThe arrow shot right at your heart and you lost consciousness");
                            Thread.sleep(1000);
                            System.out.println("\nYou have died! Game over.");
                            System.exit(0);
                        }
                    }
                    System.out.println("The trigger went off and a hidden arrow had shot you... \nAt least you've obtained the book!");
                    Thread.sleep(1500);
                    player.addItemToInventory("Ruined Book", "The book that reminds you of your past relationship"); //add book to inventory
                    System.out.println("---Ruined Book was added to your inventory---");
                    Thread.sleep(1000);
                    haveBook = true;
                }
            }
        }
        //when they return
        if (haveBook == true) {
            StoryLore.Separator(5);
            System.out.println("\nYou walk past the dingy cave that you got the ruined book from, and continue to struggle up the mountain");
            Thread.sleep(1000);}
    }

    public Boolean defeatSuitor = false;

    private void handleSuitor(Player player) throws InterruptedException {
        //create suitor enemy
        int attackPower = RandomNumber();
        Enemy enemy = new Enemy("Suitor", 150, 150, attackPower);
        if (defeatSuitor == false) {
            StoryLore.Separator(5);
            System.out.println("\nAs you trek up on the mountain you see a young lady with a sword in hand watching over the horizon" +
                    "\nYou call out to her and she looks back, showing off her sharp teeth and hissing at you.");
            Thread.sleep(1000);
            System.out.println("'Are you here for the dragon?' she says...\n");
            Thread.sleep(500);
            //prompt user
            System.out.println("\n1. Yes, I am here for the dragon");
            System.out.println("2. No, Im just lost");
            int suitorIntro = Main.readInt("", 1, 2);
            //yes
            if (suitorIntro == 1) {
                StoryLore.Separator(5);
                System.out.println("\n\n'That dragon is mine! You must defeat me before you can even see them!'");
                Thread.sleep(1000);
                System.out.println("\nPrepare for battle, or run?");
                Thread.sleep(500);
                //prompt user
                System.out.println("1. Attack");
                System.out.println("2. Run");
                int suitorFight = Main.readInt("", 1, 2);
                //battle system
                if (suitorFight == 1) {
                    StoryLore.Separator(5);
                    System.out.print("\nLETS GO TO BATTLE!\n\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    BattleStats(enemy);
                    battle(enemy);
                    if (wonFight == true) {
                        StoryLore.Separator(5);
                        displayPlayerInfo(player);
                        System.out.print("\nThinking of your dragon lover, you attack the suitor once and for all!");
                        Thread.sleep(1000);
                        System.out.print("Turned into pieces, you have finally defeated the Suitor! You may now rescue the dragon!");
                        defeatSuitor = true;
                        wonFight = false;
                    }
                    //run
                } else if (suitorFight == 2) {
                    StoryLore.Separator(5);
                    System.out.print("\nBefore she thrashes her sword around, you turn back and run down the hill! Away from her...");
                    Thread.sleep(1000);
                    displayPlayerInfo(player);
                }
                //no
            } else if (suitorIntro == 2) {
                StoryLore.Separator(5);
                System.out.print("\n'That's a lie! You are here for the dragon!'");
                Thread.sleep(1000);
                System.out.println("'You must defeat me before you can even see them!'\n");
                System.out.println("\nPrepare for battle, or run?");
                Thread.sleep(500);
                //prompt user
                System.out.println("1. Attack");
                System.out.println("2. Run");
                int suitorFight = Main.readInt("", 1, 2);
                //battle system
                if (suitorFight == 1) {
                    StoryLore.Separator(5);
                    System.out.print("\nLETS GO TO BATTLE!\n\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    BattleStats(enemy);
                    battle(enemy);
                    if (wonFight == true) {
                        StoryLore.Separator(5);
                        displayPlayerInfo(player);
                        System.out.print("\nThinking of your dragon lover, you attack the suitor once and for all!");
                        Thread.sleep(1000);
                        System.out.print("Turned into pieces, you have finally defeated the Suitor! You may now rescue the dragon!");
                        defeatSuitor = true;
                        wonFight = false;
                    }
                    //run
                } else if (suitorFight == 2) {
                    StoryLore.Separator(5);
                    System.out.print("\nBefore she thrashes her sword around, you turn back and run down the hill! Away from her\n");
                    Thread.sleep(1000);
                    displayPlayerInfo(player);
                }
            }
        }
        //when suitor already slain
        if (defeatSuitor == true) {
            StoryLore.Separator(5);
            System.out.println("\nYou walk past the suitor that you have slain, and continue to trek along the mountain...");
            Thread.sleep(1000);
        }
    }

    //Dragon lover event
    private void handleDragon(Player player) throws InterruptedException {
        //call player inventory
        Inventory playerInventory = player.getInventory();
        //to check if player has the required items in the inventory
        boolean hasRedGemstone = playerInventory.getItems().stream().anyMatch(item -> item.getName().equals("Red Gemstone"));
        boolean hasRuinedBook = playerInventory.getItems().stream().anyMatch(item -> item.getName().equals("Ruined Book"));
        boolean hasFlowerBouquet = playerInventory.getItems().stream().anyMatch(item -> item.getName().equals("Flower Bouquet"));
        if (hasRedGemstone && hasRuinedBook && hasFlowerBouquet) {
            //when all is done, put outro
            StoryLore.Outro();
        } else {
            //else
            StoryLore.NotComplete();
        }
    }



    //Quicksand event
    public boolean enteredQuickSand = false;
    public boolean firstVisitQuickSand = true;

    private void handleQuickSand(Player player) throws InterruptedException {
        if (firstVisitQuickSand) {
            StoryLore.Separator(5);
            System.out.println("You've stumbled into a pit of quicksand!");
            Thread.sleep(1000);
            System.out.println("How do you want to react?\n");
            Thread.sleep(500);
            //prompt user
            System.out.println("1. Muscle your way out of it");
            System.out.println("2. Slowly crawl across the surface");
            int quickSandAnswer = Main.readInt("", 1, 2);
            //muscle, take 20 dmg
            if (quickSandAnswer == 1) {
                StoryLore.Separator(5);
                displayPlayerInfo(player);
                System.out.println("The quicksand crushes your body as you do so, and you take 20 damage.\n");
                Thread.sleep(1000);
                enteredQuickSand = true;
                firstVisitQuickSand = false;
                player.setCurrentHealth(player.getCurrentHealth() - 20); //-20 from play current health
                //when player is dead
                if (player.getCurrentHealth() < 1) {
                    //ability to use health potion
                    Main.useHealthPotion(player);
                    if (player.getCurrentHealth() > 0) {
                        StoryLore.Separator(5);
                        System.out.println("You manage to push through and escape\n");
                        Thread.sleep(2000);
                    }
                    //else die if no health potion
                    if (player.getCurrentHealth() <= 0) {
                        StoryLore.Separator(5);
                        System.out.println("\nThe pressure of the quicksand was far too much for your frail body!");
                        Thread.sleep(1000);
                        System.out.println("\nYou have died! Game over.");
                        System.exit(0);
                    }
                }
            //safe
            } else if (quickSandAnswer == 2) {
                StoryLore.Separator(5);
                displayPlayerInfo(player);
                System.out.println("You carefully crawl across the surface of the quicksand and escape, avoiding any bodily harm.\n");
                enteredQuickSand = true;
                firstVisitQuickSand = false;
                Thread.sleep(1000);
            }
        //not first visit
        } else if (!firstVisitQuickSand) {
            StoryLore.Separator(5);
            System.out.println("\nBefore you is a dangerous pit of quicksand. You've dealt with this hazard before, so you carefully maneuver around it, avoiding harm.\n");
            Thread.sleep(1000);
        }
    }

    //Marsh non-event
    private void handleMarsh(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nYou stumble into a swampy marshland.");
        Thread.sleep(1000);
        System.out.println("The sounds of far-off birds and other chittering creatures surround you, and the smell of rotten wood and decay fills the air." +
                "\nYour feet sink several inches into the ground with each step.\n");
        Thread.sleep(1000);
    }

    //Woods non-event
    private void handleWoods(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nYou find yourself in the Silverglade Woods.");
        Thread.sleep(1000);
        System.out.println("Silvery-grey coloured trunks of all sizes shoot upwards, and a thick canopy blocks out most of the sky." +
                "\nThin beams of golden light break through the foliage and speckle the ground like tiny gemstones, making for a beautiful and enchanting sight.\n");
        Thread.sleep(1000);
    }

    //Sandyplain non-event
    private void handleSandyPlain(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nA damp, sandy plain stretches out before you.");
        Thread.sleep(1000);
        System.out.println("over the area you can spot small crustaceans scurrying in and out of their burrows." +
                "\nYou can hear the sound of rushing water to the south; a river must be close by.\n");
        Thread.sleep(1000);
    }

    //Greenfield north side non-event
    private void handleGreenFieldNorth(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nYou stand in a plain, grassy field.");
        Thread.sleep(1000);
        System.out.print("Tufts of yellow-green plants are scattered about, and a chill Southerly-wind buffets you." +
                "\nYou see massive footprints in the ground leading east; a gigantic (and likely dangerous) creature must have left these.\n");
        Thread.sleep(1000);
    }

    //Greenfield south side non-event
    private void handleGreenFieldSouth(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nYou've entered a sparse grassland. To your north you hear the rushing water of the river," +
                "\nand to your east you see a steep mountain erupting from the ground.");
        Thread.sleep(1000);
        System.out.println("Gulls circle overhead; their squawks and screeches piercing the otherwise peaceful atmosphere.\n");
        Thread.sleep(1000);
    }

    //Mountain entrance non-event
    private void handleMountainEntrance(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nTo your south a small rocky path winds its way up the mountain, flanked on either side by steep cliffs.");
        Thread.sleep(1000);
        System.out.println("A chill wind blows through you; the temperature is dropping as the elevation rises.\n");
        Thread.sleep(1000);
    }

    //Craggy rocks non-event
    private void handleCraggyRocks(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nThe path in this area is difficult to follow; a mess of jagged rocks and large boulders litter the ground." +
                "\nIt will be slow going but with careful foot placement you'll be able to hike onwards.");
        Thread.sleep(1000);
        System.out.println("The path continues to the south up the mountain, but you also spy a hidden cave to your east.\n");
        Thread.sleep(1000);
    }

    //Cliff edge non-event
    private void handleCliffEdge(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nYou stand at the precipice of a large cliff edge." +
                "\nYou peer over the edge and see a large valley down below, with a small river running though it.");
        Thread.sleep(1000);
        System.out.println("In the distance beyond the valley a vast, misty forest sprawls endlessly across the landscape.\n");
        Thread.sleep(1000);
    }

    //Mountain east non-event, south direction is blocked
    private void handleMountainEast(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nA sheer cliff face rises up around you to the south and east, creating an impenetrable barrier.");
        Thread.sleep(1000);
        System.out.println("You spot a family of mountain goats; these sure-footed creatures are somehow scrambling up the side of this impossibly-steep mountain.\n");
        Thread.sleep(1000);
    }

    //Default event, in case cases no catch
    private void handleDefaultEvent(Player player) throws InterruptedException {
        StoryLore.Separator(5);
        System.out.println("\nYou've encountered an unknown area.\n");
        Thread.sleep(2500);
    }
}
