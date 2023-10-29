//Stores methods to print out parts of the story
public class StoryLore {

    //To separate texts, create a FOR loop
    public static void Separator(int n){
        for (int i = 0; i < n; i++)
            System.out.println();
    }

//INTRO LORE
    public static void Introduction() throws InterruptedException {
        System.out.println("The journey to the Dragon's heart\n------------------");
        System.out.println("Final Project");
        System.out.println("Made by Millie, Monica, and Tamara");
        System.out.println("s3934065, s4014843, s4009144");
        Thread.sleep(1000);//wait
        Main.clearScreen();
        System.out.println("BEGINNING \n------------------");

        Separator(5);//prints 5 lines
        System.out.println("As you walk through the forest, you see a poster claiming that a dragon is in need of help");
        Thread.sleep(2000);//wait
        System.out.println("You look closer and that dragon looks familiar... Its the dragon that ran away at the alter on your wedding day!");
        Thread.sleep(2000);//wait
        System.out.println("As you read the poster further, you realise your get-away bride is stuck on top of a mountain just south-east from where you are");
        Thread.sleep(2000);//wait
        System.out.println("You want to help them out, but you also want to win their heart back; so you begin to think of ways to win them back...");
        Thread.sleep(2000);//wait
        System.out.println("...");
        Thread.sleep(1000);//wait
        System.out.println("...");
        Thread.sleep(1000);//wait
        System.out.println("!!!");
        Thread.sleep(2000);//wait
        System.out.println("You make plan to get them a bouquet of flowers, a red gem, and a book as they loved those when you guys were together!");
        Thread.sleep(3000);//wait
        System.out.println("You should make your way to get these items and return them to your get-away bride");
        Thread.sleep(1000);//wait
        System.out.println("You are set on an adventure, shall we start?");
        Thread.sleep(3000);//wait
        Separator(5);//prints 5 lines
    }

    //WHEN PLAYER GETS TO DRAGON WITHOUT ALL THE ITEMS
    public static void NotComplete() throws InterruptedException {
        Separator(5);//prints 5 lines
        System.out.println("As you continue to hike up the mountain, you begin to get nervous in meeting the dragon...");
        Thread.sleep(2000);//wait
        System.out.println("!!!");
        Thread.sleep(1000);//wait
        System.out.println("!!!");
        Thread.sleep(1000);//wait
        System.out.println("!!!");
        Thread.sleep(1000);//wait
        System.out.println("Luckily you began to ponder about your interaction because you completely forgot to grab some items!");
        Thread.sleep(2000);//wait
        System.out.println("Without a ruined book, a red gem, and a bouquet of flowers, how do you supposed you get their heart back?");
        Thread.sleep(2000);//wait
        System.out.println("You remind yourself to return with ALL the items");
        Thread.sleep(2000);//wait
        System.out.println("Otherwise there would be no chance in getting the dragon's heart back...");
        Thread.sleep(3000);//wait
        Separator(5);//prints 5 lines
    }

    //WHEN PLAYER COMPLETES GAME
    public static void Outro() throws InterruptedException {
        Main.clearScreen();
        System.out.println("OUTRO \n------------------");
        Separator(5);//prints 5 lines
        System.out.println("Disheveled after defeating the suitor and hiking up the mountain, you finally see a hint of a strong ruby colour over the horizon");
        Thread.sleep(2000);//wait
        System.out.println("As you walk over the mountain, you see a clear view of your beautiful red dragon; looking scared and helpless");
        Thread.sleep(2000);//wait
        System.out.println("You cant help but stay still and look in awe as you bask in their beauty...");
        Thread.sleep(2000);//wait
        System.out.println("Their looks still as enchanting as the day they left you at the alter");
        Thread.sleep(2000);//wait
        System.out.println("...");
        Thread.sleep(3000);//wait
        System.out.println("You snap out of your gaze and finally run towards your Lover");
        Thread.sleep(2000);//wait
        System.out.println("'Im here!' you say, booking it across the ragged mountain floor");
        Thread.sleep(2000);//wait
        System.out.println("As if in slow-motion, the dragon drags their head towards your voice, your eyes lock together and time seems to stand still");
        Thread.sleep(3000);//wait
        System.out.println("All the memories you had with them, rush back to you...");
        Thread.sleep(3000);//wait
        System.out.println("You remember the day you picked out a bouquet of flowers to ask them to be your partner...");
        Thread.sleep(2000);//wait
        System.out.println("The day where you and the dragon picked out a book as a reminder of your love to another...");
        Thread.sleep(2000);//wait
        System.out.println("And finally, the day where you were picking out a wedding ring and the first glance of the red gem thinking that it was perfect for them...");
        Thread.sleep(2000);//wait
        System.out.println("Its all coming back now");
        Thread.sleep(2000);//wait
        System.out.println("You feel the spark between you igniting again, and it only powered your energy even more");
        Thread.sleep(2000);//wait
        System.out.println("After what felt like hours, you finally reach them");
        Thread.sleep(2000);//wait
        System.out.println("'My Dragon, are you okay?' You are out of breath but those words seem to utter out your mouth");
        Thread.sleep(2000);//wait
        System.out.println("'My love, why are you here? Dont you remember how I left the alter?' They say...");
        Thread.sleep(2000);//wait
        System.out.println("'Mi amore, it doesnt matter, I saw the poster and I had to help you! \nI cant just leave you stranded and helpless by yourself!' You proclaim.");
        Thread.sleep(2000);//wait
        System.out.println("Suddenly the Dragons' expression turned sour, 'HELPLESS? DONT YOU KNOW IM A DRAGON??? I CAN HELP MYSELF!'");
        Thread.sleep(2000);//wait
        System.out.println("The spark that you thought was mutual between the both of you, suddenly disappear and it hits you...");
        Thread.sleep(2000);//wait
        System.out.println("'I left the alter because I had another lover... They are waiting just outside for me!' They cry, \nEverything makes sense now...");
        Thread.sleep(3000);//wait
        System.out.println("...");
        Thread.sleep(3000);//wait
        System.out.println("...");
        Thread.sleep(3000);//wait
        System.out.println("You've been a fool all along...");
        Thread.sleep(3000);//wait
        System.out.println("You stumble backwards and fall onto the soft snow as the dragon begins to tower over you intimidatingly");
        Thread.sleep(2000);//wait
        System.out.println("'You could never live up to that lady waiting outside for me! She is all I wanted and more, you were just a mistake!'\nCant you see?'");
        Thread.sleep(2000);//wait
        System.out.println("You begin to tremble, using all the power you have left, you reach out your pockets and show the dragon what you have brought for them");
        Thread.sleep(2000);//wait
        System.out.println("'But I got this for you Mi Amore, I have loved you and will always love you!\nI dont understand, I saw the poster, I saw the help!' You try to fight your tears as you proclaim your love to them");
        Thread.sleep(2000);//wait
        System.out.println("'This is why I never liked you. That poster was to get help for my new borne children! I need a nanny!'");
        Thread.sleep(2000);//wait
        System.out.println("Reality crumbles around you as you look back at what you've done....");
        Thread.sleep(3000);//wait
        System.out.println("Half human/dragon children peek their head from under the dragon's belly, eyes wide and glowing with curiosity");
        Thread.sleep(2000);//wait
        System.out.println("What have you done...");
        Thread.sleep(3000);//wait
        System.out.println("Did you just make these children become half-orphans?");
        Thread.sleep(2000);//wait
        System.out.println("...");
        Thread.sleep(3000);//wait
        System.out.println("...");
        Thread.sleep(3000);//wait
        System.out.println("...");
        Thread.sleep(3000);//wait
        Separator(5);//prints 5 lines
        System.out.println("THE END \n------------------");
        System.out.println("Thank you for playing our game <3");
        System.exit(0);
    }
}


