import javax.swing.*;
import java.util.concurrent.TimeUnit;

//Stores methods to print out parts of the story
public class StoryLore {
    //To separate texts
    public static void Separator(int n){
        for (int i = 0; i < n; i++)
            System.out.println();
    }

//INTRO LORE
    public static void Introduction() throws InterruptedException {
        Main.clearScreen();
        System.out.println("BEGINNING");
        Separator(5);
        System.out.println("As you walk through the forest, you see a poster claiming that a dragon is in need of help");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("You look closer and that dragon looks familiar... Its your get-away bride!");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("As you read the poster further, you realise your get-away bride is stuck on top of a mountain just south-east from where you are");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("You want to help them out, but you also want to win their heart back; so you begin to think of ways to win them back...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("!!!");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("You make plan to get them flowers, a gem, and a book as they loved those when you guys were together");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("You are set on an adventure, shall we start?");
        TimeUnit.SECONDS.sleep(3);
        Separator(5);
    }
}


