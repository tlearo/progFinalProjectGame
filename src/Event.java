import java.util.List;
import java.util.Scanner;

//Event Squares
public class Event {
    Scanner userInput = new Scanner(System.in); //implement scanner input
    private Player player; //assigning relationship to classes
    private Enemy enemy;
    private Inventory inventory; //constructor

    public boolean hasBoat;
    gameMap gameMap = new gameMap(); // Initializing gameMap

    public Event(Player player) {
        this.player = player;
        this.inventory = player.getInventory(); // Assign the player's inventory to the Event's inventory
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

    //Method to display stuff
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

    public int randomAttackPower;

    //Random Number Generator method
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

    public void battle(Enemy enemy) throws InterruptedException {
        System.out.println("\nYou attacked the " + enemy.getEnemyName() + " and did " + player.getAttackDamage() + " damage!");

        enemy.setCurrentHealth(enemy.getCurrentHealth() - player.getAttackDamage());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (enemy.getCurrentHealth() < 1) {
            System.out.println("\nThe " + enemy.getEnemyName() + " fell to its knees as you attack them in one big blow");
            System.out.println("\nAfter all your valiant efforts, you have won the battle!");
            Thread.sleep(1500);
            System.out.println("\nYou scour around their body and find 100 gold!");
            displayPlayerInfo(player);
        }
        if (enemy.getCurrentHealth() > 0) {
            int EnemyDamage;
            EnemyDamage = (enemy.getAttackDamage() + (new java.util.Random().nextInt(10)));
            System.out.println("\nThe " + enemy.getEnemyName() + " attacked for " + EnemyDamage + " damage!\n");
            player.setCurrentHealth(player.getCurrentHealth() - EnemyDamage);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BattleStats(enemy);

            if (player.getCurrentHealth() < 1) {
                System.out.println("\nYou lost the fight!\nYou have died! Game over.");
                System.exit(0);
            } else if (player.getCurrentHealth() > 0) {
                System.out.println("\nDo you want to keep attacking the " + enemy.getEnemyName() + "?");
                System.out.println("\n1. Attack\n2. Run");
                int ContinueFight = Main.readInt("", 2);
                if (ContinueFight == 1) {
                    battle(enemy);
                } else if (ContinueFight == 2) {
                    System.out.print("\nAs you continue to fight the " + enemy.getEnemyName() + ", you find yourself getting restless...");
                    Thread.sleep(1500);
                    System.out.print("\nYou decide its best not to continue fighting this Ogre and you shall return when you are ready!");
                    displayPlayerInfo(player);
                }
            }
        }
    }

    //Fairy circle event
    private void handleFairyCircle(Player player) throws InterruptedException {
        int attackPower = RandomNumber();
        Enemy enemy = new Enemy("Evil Fairy", 100, 100, attackPower);
        System.out.println("\nYou emerge out of the scrub into a grassy clearing.\n" +
                "You see a large circle of red and white spotted mushrooms surrounding a small tree stump.\n" +
                "Nestled within the stump is a beautiful ruby red gemstone! It's iridescent glow reminds you of the dragon's lovely eyes.\n" +
                "You feel the strong urge to covet this gemstone!\n" +
                "Do you enter the mushroom circle to take it?\n");
        System.out.println("1. Enter");
        System.out.println("2. Leave");
        int enterCircle = Main.readInt("", 2);
        if (enterCircle == 1) {
            System.out.print("\nYou step over the line of mushrooms, but as soon as your foot touches \n" +
                    "the ground on the other side a swirl of flower petals and leaves rush upwards in front of you!\n" +
                    "When the air clears, you see a beautiful fairy queen standing before you.\n" +
                    "'How dare you enter my circle without my permission! Leave or you shall die!'\n");
            System.out.println("1. Attack");
            System.out.println("2. Run");
            int fairyFight = Main.readInt("", 2);
            if (fairyFight == 1) {
                System.out.print("\nLETS GO TO BATTLE!\n\n");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                BattleStats(enemy);
                battle(enemy);
            } else if (fairyFight == 2) {
                System.out.print("\nRUN");
            } else if (enterCircle == 2) {
                System.out.print("\nYou decide to give the mushroom circle a wide berth.\n");
            }
        }
    }

    //Boulder Sword event
    public boolean haveSword = false;

    private void handleGetSword(Player player) throws InterruptedException {
        while (!haveSword) {
            System.out.println("\nYou see the hilt of a sword protruding from a crack in a large boulder.");
            Thread.sleep(1000);
            System.out.println("Would you like to pull it out?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int swordAnswer = Main.readInt("", 2);
            if (swordAnswer == 1) {
                StoryLore.Separator(5);
                System.out.println("\nWith one swift, strong motion you free the sword from it's stone!");
                Thread.sleep(1000);
                displayPlayerInfo(player);
                System.out.println("---Elven Sword was added to your inventory---");
                player.addItemToInventory("Elven Sword", "A sharp and shiny sword of excellent quality");
                Thread.sleep(500);
                haveSword = true;
                player.setAttackDamage(player.getAttackDamage() + 10);
                break;
            } else if (swordAnswer == 2) {
                displayPlayerInfo(player);
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
        hasBoat = inventory.getItems().stream().anyMatch(item -> item.getName().equals("Boat"));
        if (hasBoat) {
            System.out.println("\nA swiftly flowing river surges in front of you. " +
                    "With the boat you purchased, you're able to travel across it!");
        } else {
            System.out.println("\nA swiftly flowing river surges in front of you.\n" +
                    "It would be far too dangerous to try and swim across. Perhaps a boat would help?");
        }
    }

    //Cozy Cottage event
    private void handleCottage(Player player) throws InterruptedException {
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
            displayPlayerInfo(player);
            System.out.println("\n---You are fully healed---");
            Thread.sleep(500);
        } else if (cottageAnswer == 2) {
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
            System.out.println("\nYou emerge into a clearing, in the middle of which lays a pile of forest debris.");
            Thread.sleep(1000);
            System.out.println("\nWhat do you do?\n");
            System.out.println("1. Confidently walk across the debris");
            System.out.println("2. Avoid the debris");
            int spikeTrapAnswer = Main.readInt("", 2);

            if (spikeTrapAnswer == 1) {
                StoryLore.Separator(5);
                System.out.println("\nYou stride across the debris without a care in the world.\n" +
                        "Suddenly, the ground below you gives out!\n" +
                        "You tumble downwards into a pit of sharpened spikes and take 20 damage!\n" +
                        "You manage to crawl out of the pit having learned your lesson regarding reckless behaviour.\n");
                player.setCurrentHealth(player.getCurrentHealth() - 20);
                Thread.sleep(1000);
                displayPlayerInfo(player);
            } else if (spikeTrapAnswer == 2) {
                StoryLore.Separator(5);
                System.out.println("You carefully crawl across the surface of the quicksand and escape, avoiding any bodily harm.\n");
                Thread.sleep(1000);
                displayPlayerInfo(player);
            }
            enteredSpikeTrap = true;
            firstVisitSpikeTrap = false;
        } else if (!firstVisitSpikeTrap) {
            System.out.println("\nBefore you is a dangerous spike trap. You've dealt with this hazard before, so you carefully maneuver around it, avoiding harm.\n");
        }

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
                displayPlayerInfo(player);
                System.out.println("\nYou carefully gather all her favourite flowers into a gorgeous bouquet");
                Thread.sleep(2000);
                System.out.println("---Flower Bouquet was added to your inventory---");
                player.addItemToInventory("Flower Bouquet", "Handpicked bouquet of the Dragons favourite flowers");
                haveFlower = true;
                break;
            } else if (swordAnswer == 2) {
                displayPlayerInfo(player);
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

    // Create an instance of the inventory for the shop (outside the method)
    Inventory shopInventory = new Inventory();

    public void handleShop(Player player) throws InterruptedException {
        // Add items to the shop's inventory with costs (you can do this once at initialization)
        if (shopInventory.getItems().isEmpty()) {
            shopInventory.addItem("Potion", "Heals you fully when your health is 0", 50, player.getMaxHealth()); // Set cost and max health here
            shopInventory.addItem("Armor", "Boosts your max health (+50)", 50, 50);
            shopInventory.addItem("Boat", "Can be used to cross a flowing river", 100, 0);
        }

        // Display the shop's inventory
        List<Inventory.Item> shopItems = shopInventory.getItems();
        System.out.println("\nWelcome to the shop!\nHere's what's available for purchase:");

        for (int i = 0; i < shopItems.size(); i++) {
            Inventory.Item item = shopItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getDescription() + " (Cost: " + item.getCost() + " gold)");
        }

        boolean inShop = true; // Flag to track if the player is in the shop

        while (inShop) {
            System.out.println("Enter the item number you want to buy (or 0 to exit): ");
            String choiceInput = userInput.next();

            if (choiceInput.equals("0")) {
                System.out.println("\nThank you for visiting the shop!\n");
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
                                System.out.println("\nYour health is increased by " + hpGranted + " HP.\n");
                                Thread.sleep(1000);
                                Display.health(player);
                                Display.gold(player);
                            } else {
                                // Add the purchased item to the player's inventory (e.g., Potion or Boat)
                                player.getInventory().addItem(selectedItem.getName(), selectedItem.getDescription(), cost, hpGranted);
                                System.out.println("\nYou bought " + selectedItem.getName() + " for " + cost + " gold.\n");
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
                    System.out.println("\nInvalid input. Please enter a valid item number or 0 to exit.\n");
                    Thread.sleep(1000);
                }
            }
        }
    }

    //Ogre event
    private void handleOgre(Player player) throws InterruptedException {
        int attackPower = RandomNumber();
        Enemy enemy = new Enemy("Ogre", 200, 200, attackPower);
        System.out.println("\nYou step into a dusty clearing, the wind whips the dirt up around you momentarily obscuring your vision." +
                "\nAfter the dust settles you see an enormous green Ogre standing before you. It towers over you, and it's eyes gleam with bloodlust.");
        Thread.sleep(1500);
        System.out.println("A greedy smile creeps across it's face, and then it lets out a bellowing roar!" +
                "\n\nPrepare for battle, or run!");
        System.out.println("1. Attack");
        System.out.println("2. Run");
        int ogreFight = Main.readInt("", 2);
        if (ogreFight == 1) {
            System.out.print("\nLETS GO TO BATTLE!\n\n");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BattleStats(enemy);
            battle(enemy);
        } else if (ogreFight == 2) {
            System.out.print("\nHis roar gave you a fright and decided not to pick this battle this time...");
            Thread.sleep(1500);
            System.out.print("\nYou shall return when you are ready!");
        }
    }

    //Enchanted book cavern event
    public Boolean haveBook = false;

    private void handleCavern(Player player) throws InterruptedException {
        gameMap gameMap = new gameMap(); // Initializing gameMap
        while (haveBook == false) {
            System.out.println("\nYou walk towards the dark dingy cave and stumble upon a library, illuminated by flowing wisps.");
            Thread.sleep(1000);
            System.out.println("Straight ahead you see a podium enclosing a ruined book. \nIt looks like the book that you threw when the dragon and you had an argument this one time...");
            Thread.sleep(1000);
            System.out.println("You want to grab it as; although it held a dark memory, the book has been intertwined in both of your lives and you feel as though the Dragon would appreciate it");
            Thread.sleep(2000);
            System.out.println("Before you reach for the book, your sense heightens and you feel a cold breeze blow in through the cave. \nIs there something waiting for you?");
            Thread.sleep(1000);
            System.out.println("\nWould you like to reach for the book?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("3. Inspect the podium");
            int bookAnswer = Main.readInt("", 3);
            if (bookAnswer == 1) {
                System.out.println("\nYou grab the book off the podium and hear a trigger!");
                //take damage
                player.setCurrentHealth(player.getCurrentHealth() - 20);
                Thread.sleep(1000);
                System.out.println("OOF!");
                Thread.sleep(500);
                System.out.println("You have been hit with a hidden arrow and taken 20 damage\nThrough the pain, you have obtained the book!");
                Thread.sleep(2500);
                player.addItemToInventory("Ruined Book", "The book that reminds you of your past relationship");
                displayPlayerInfo(player);
                System.out.println("---Ruined Book was added to your inventory---");
                haveBook = true;
                break;
            } else if (bookAnswer == 2) {
                System.out.println("\nYou leave the book alone, feeling a sense of sadness wash over you.\nThe book would help win the Dragon's heart over...");
            } else if (bookAnswer == 3) {
                StoryLore.Separator(5);
                System.out.println("\nAs you look closer into the podium, you realise the book is on top of a pressure plate.\nIf you had lifted the book, it would trigger a trap!");
                Thread.sleep(1000);
                System.out.println("You look around the cave some more to look for a replacement and see:\n- A slab of rock that seems to be the same size as the book \n- And a pile of dirt that has the potential to weight the same as the book\nthat you could replace the book with.");
                Thread.sleep(2000);
                System.out.println("\nWhich do you choose to replace the book with?");
                System.out.println("1. A slab of rock");
                System.out.println("2. A pile of dirt");
                Thread.sleep(2000);
                int bookTrapAnswer = Main.readInt("", 2);
                if (bookTrapAnswer == 1) {
                    System.out.println("You grab the slab of rock and quickly lift the book to swiftly put the rock in replacement");
                    Thread.sleep(1000);
                    System.out.println("It worked and you have obtained the book!");
                    Thread.sleep(2500);
                    player.addItemToInventory("Ruined Book", "The book that reminds you of your past relationship");
                    displayPlayerInfo(player);
                    System.out.println("---Ruined Book was added to your inventory---");
                    haveBook = true;
                    break;
                } else if (bookTrapAnswer == 2) {
                    System.out.println("You grab a handful of dirt and quickly try to replace the book. \nAs you lift the ruined book, the handful of dirt is flowing out of your hand and it was not weighted enough to work as a replacement!");
                    Thread.sleep(2000);
                    System.out.println("OUCH!");
                    //take damage
                    player.setCurrentHealth(player.getCurrentHealth() - 20);
                    System.out.println("The trigger went off and a hidden arrow had shot you... \nAt least you've obtained the book!");
                    Thread.sleep(2500);
                    player.addItemToInventory("Ruined Book", "The book that reminds you of your past relationship");
                    System.out.println("---Ruined Book was added to your inventory---");
                    displayPlayerInfo(player);
                    haveBook = true;
                    break;
                }
            }
            if (haveBook == true) {
                System.out.println("\nYou walk past the dingy cave that you got the ruined book from, and continue to struggle up the mountain");
                Thread.sleep(1000);
            }
        }
    }

    public Boolean defeatSuitor = false;

    private void handleSuitor(Player player) throws InterruptedException {
        int attackPower = RandomNumber();
        Enemy enemy = new Enemy("Suitor", 150, 150, attackPower);
        while (defeatSuitor == false) {
            System.out.println("\nAs you trek up on the mountain you see a young lady with a sword in hand watching over the horizon" +
                    "\nYou call out to her and she looks back, showing off her sharp teeth and hissing at you.");
            Thread.sleep(1500);
            System.out.println("'Are you here for the dragon?' she says...\n");
            Thread.sleep(1500);
            System.out.println("\n1. Yes, I am here for the dragon");
            System.out.println("2. No, Im just lost");
            int suitorIntro = Main.readInt("", 2);
            if (suitorIntro == 1) {
                System.out.println("\n\n'That dragon is mine! You must defeat me before you can even see them!'");
                Thread.sleep(1500);
                System.out.println("\nPrepare for battle, or run?");
                System.out.println("1. Attack");
                System.out.println("2. Run");
                int suitorFight = Main.readInt("", 2);
                if (suitorFight == 1) {
                    System.out.print("\nLETS GO TO BATTLE!\n\n");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    BattleStats(enemy);
                    battle(enemy);
                } else if (suitorFight == 2) {
                    System.out.print("\n");
                    Thread.sleep(1500);
                    System.out.print("\nBefore she thrashes her sword around, you turn back and run down the hill! Away from her");
                }
            } else if (suitorIntro == 2) {
                System.out.print("\n'That's a lie! You are here for the dragon!'");
                Thread.sleep(1500);
                System.out.println("'You must defeat me before you can even see them!'\n");
                System.out.println("\nPrepare for battle, or run?");
                System.out.println("1. Attack");
                System.out.println("2. Run");
                int suitorFight = Main.readInt("", 2);
                if (suitorFight == 1) {
                    System.out.print("\nLETS GO TO BATTLE!\n\n");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    BattleStats(enemy);
                    battle(enemy);
                } else if (suitorFight == 2) {
                    System.out.print("\n");
                    Thread.sleep(1500);
                    System.out.print("\nBefore she thrashes her sword around, you turn back and run down the hill! Away from her");
                }
            }
        }
        if (defeatSuitor == true) {
            System.out.println("\nYou walk past the suitor that you have slain, and continue to trek along the mountain...");
            Thread.sleep(1000);
        }
    }

    //Dragon lover event
    private void handleDragon(Player player) {
        System.out.println("testing dragon");
    }

    //Quicksand event
    public boolean enteredQuickSand = false;
    public boolean firstVisitQuickSand = true;

    private void handleQuickSand(Player player) throws InterruptedException {
        if (firstVisitQuickSand) {
            System.out.println("\nYou've stumbled into a pit of quicksand!");
            Thread.sleep(1000);
            System.out.println("\nHow do you want to react?\n");
            System.out.println("1. Muscle your way out of it");
            System.out.println("2. Slowly crawl across the surface");
            int quickSandAnswer = Main.readInt("", 2);

            if (quickSandAnswer == 1) {
                StoryLore.Separator(5);
                System.out.println("You manage to push through and escape, but the quicksand crushes your body as you do so, and you take 20 damage.\n");
                Thread.sleep(1000);
                player.setCurrentHealth(player.getCurrentHealth() - 20);
                displayPlayerInfo(player);
            } else if (quickSandAnswer == 2) {
                StoryLore.Separator(5);
                System.out.println("You carefully crawl across the surface of the quicksand and escape, avoiding any bodily harm.\n");
                Thread.sleep(1000);
                displayPlayerInfo(player);
            }
            enteredQuickSand = true;
            firstVisitQuickSand = false;
        } else if (!firstVisitQuickSand) {
            System.out.println("\nBefore you is a dangerous pit of quicksand. You've dealt with this hazard before, so you carefully maneuver around it, avoiding harm.\n");
        }
    }

    //Marsh non-event
    private void handleMarsh(Player player) throws InterruptedException {
        System.out.println("\nYou stumble into a swampy marshland.");
        Thread.sleep(1000);
        System.out.println("\nThe sounds of far-off birds and other chittering creatures surround you, and the smell of rotten wood and decay fills the air." +
                "\nYour feet sink several inches into the ground with each step.\n");
    }

    //Woods non-event
    private void handleWoods(Player player) throws InterruptedException {
        System.out.println("\nYou find yourself in the Silverglade Woods.");
        Thread.sleep(1000);
        System.out.println("\nSilvery-grey coloured trunks of all sizes shoot upwards, and a thick canopy blocks out most of the sky." +
                "\nThin beams of golden light break through the foliage and speckle the ground like tiny gemstones, making for a beautiful and enchanting sight.\n");
    }

    //Sandyplain non-event
    private void handleSandyPlain(Player player) throws InterruptedException {
        System.out.println("\nA damp, sandy plain stretches out before you.");
        Thread.sleep(1000);
        System.out.println("over the area you can spot small crustaceans scurrying in and out of their burrows." +
                "\nYou can hear the sound of rushing water to the south; a river must be close by.\n");
    }

    //Greenfield north side non-event
    private void handleGreenFieldNorth(Player player) throws InterruptedException {
        System.out.println("\nYou stand in a plain, grassy field.");
        Thread.sleep(1000);
        System.out.print("Tufts of yellow-green plants are scattered about, and a chill Southerly-wind buffets you." +
                "\nYou see massive footprints in the ground leading east; a gigantic (and likely dangerous) creature must have left these.\n");
    }

    //Greenfield south side non-event
    private void handleGreenFieldSouth(Player player) throws InterruptedException {
        System.out.println("\nYou've entered a sparse grassland. To your north you hear the rushing water of the river," +
                "\nand to your east you see a steep mountain erupting from the ground.");
        Thread.sleep(1000);
        System.out.println("\nGulls circle overhead; their squawks and screeches piercing the otherwise peaceful atmosphere.\n");
    }

    //Mountain entrance non-event
    private void handleMountainEntrance(Player player) throws InterruptedException {
        System.out.println("\nTo your south a small rocky path winds its way up the mountain, flanked on either side by steep cliffs.");
        Thread.sleep(1000);
        System.out.println("\nA chill wind blows through you; the temperature is dropping as the elevation rises.\n");
    }

    //Craggy rocks non-event
    private void handleCraggyRocks(Player player) throws InterruptedException {
        System.out.println("\nThe path in this area is difficult to follow; a mess of jagged rocks and large boulders litter the ground." +
                "\nIt will be slow going but with careful foot placement you'll be able to hike onwards.");
        Thread.sleep(1000);
        System.out.println("\nThe path continues to the south up the mountain, but you also spy a hidden cave to your east.\n");
    }

    //Cliff edge non-event
    private void handleCliffEdge(Player player) throws InterruptedException {
        System.out.println("\nYou stand at the precipice of a large cliff edge." +
                "\nYou peer over the edge and see a large valley down below, with a small river running though it.");
        Thread.sleep(1000);
        System.out.println("\nIn the distance beyond the valley a vast, misty forest sprawls endlessly across the landscape.\n");
    }

    //Mountain east non-event, south direction is blocked
    private void handleMountainEast(Player player) throws InterruptedException {
        System.out.println("\nA sheer cliff face rises up around you to the south and east, creating an impenetrable barrier.");
        Thread.sleep(1000);
        System.out.println("\nYou spot a family of mountain goats; these sure-footed creatures are somehow scrambling up the side of this impossibly-steep mountain.\n");
    }

    //Default event, in case cases no catch
    private void handleDefaultEvent(Player player) throws InterruptedException {
        System.out.println("\nYou've encountered an unknown area.\n");
        Thread.sleep(2500);
    }
}
