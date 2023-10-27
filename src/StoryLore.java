//Stores methods to print out parts of the story
public class StoryLore {

    //To separate texts, create a FOR loop
    public static void Separator(int n){
        for (int i = 0; i < n; i++)
            System.out.println();
    }

//INTRO LORE
    public static void Introduction() throws InterruptedException {
        Main.clearScreen();
        System.out.println("BEGINNING");
        Separator(5);//prints 5 lines
        System.out.println("As you walk through the forest, you see a poster claiming that a dragon is in need of help");
        Thread.sleep(2000);//wait
        System.out.println("You look closer and that dragon looks familiar... Its your get-away bride!");
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
        System.out.println("You make plan to get them flowers, a gem, and a book as they loved those when you guys were together");
        Thread.sleep(3000);//wait
        System.out.println("You are set on an adventure, shall we start?");
        Thread.sleep(3000);//wait
        Separator(5);//prints 5 lines
    }
}


