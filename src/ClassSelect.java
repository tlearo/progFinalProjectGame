import java.util.Scanner;
public class ClassSelect {
    public static void ClassSelect() {
        //Choosing your class
        boolean classSet = false;
        Scanner userInput = new Scanner(System.in); //implementing new scanner
        String playerClass;
        int currentHealth = 100;
        int maxHealth = 100;
        int attackDamage = 10;
        do {
            System.out.println("What kind of adventurer are you?");
            System.out.println("1. Guardian (High health, low attack)");
            System.out.println("2. Assassin (Low health, high attack");
            playerClass = userInput.next();
            if(playerClass.equals(1)) {
                playerClass = "Guardian";
            } else if (playerClass.equals(2)) {
                playerClass = "Assassin";
            }
            System.out.println("Your class is " + playerClass + ", correct?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int nameConfirm = readInt("-> ", 2);
            if (nameConfirm == 1){
                playerClass = "Guardian";
                currentHealth = 150;
                maxHealth = 150;
                attackDamage = 10;
                classSet = true;
            } else if (nameConfirm == 2){
                playerClass = "Assassin";
                currentHealth = 80;
                maxHealth = 80;
                attackDamage = 20;
                classSet = true;
            }

        } while (!classSet);
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
