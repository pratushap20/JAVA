import java.util.Random;
import java.util.Scanner;
class Hangman {
    String [] words = {"superman","batman","wonderwoman","robin","spiderman","antman"};
    String final_word;
    char c;
    int tries=0;
    char [] un = new char[20];
    int un_index=0;
    void generate_words()
    {
        Random r = new Random();
        int choice = r.nextInt(words.length);
        final_word = words[choice];
        System.out.println(final_word);
    }
    void create_dashes() {
        for (int i = 0; i < final_word.length(); i++) {
            un[i] = '_';
        }
    }
    void update_dashes()
    {
        boolean check=false;
        for(int i=0;i<final_word.length();i++)
        {
            if(c==final_word.charAt(i))
            {
                check = true;
                un[i]=c;
            }
        }
        if(check==false)
        {
            tries++;
            display_hangman(tries);
        }
    }
    void display_dashes()
    {
        for(int i=0;i<final_word.length();i++)
        {
            System.out.print(un[i]+" ");
        }
    }
    void user_input()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter a Character");
        c = s.next().charAt(0);
    }



    void display_hangman(int n)
    {


        if(n==1)
        {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
            System.out.print("You have 2 tries left");

        }
        else if(n==2)
        {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.print("You have 1 tries left");

        }
        else if(n==3)
        {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.print("You have 0 tries left");

        }
        else
        {
            System.out.print("You Lost");

        }

    }
    // This is the main method of the java program
    public static void main(String [] args) {
        Hangman h = new Hangman();
        h.generate_words();


        h.create_dashes();

        while (true) {
            h.user_input();
            h.update_dashes();
            int count = h.final_word.length();
            int j = 0;
            for (int i = 0; i < h.final_word.length(); i++) {
                if (h.un[i] != '_') {
                    j++;
                }
            }
            if (j == count) {
                System.out.println("You won");
                break;
            } else {
                if (h.tries > 3)
                {
                    break;
                }
                else
                    {
                    h.display_dashes();
                }
            }

        }




    }
}
