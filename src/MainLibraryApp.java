import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Megan on 4/25/2017.
 */


public class MainLibraryApp {
    public static void main(String[] args) {
//        WelcomeMenu.selectMenuOption();
//        System.out.println("Hello World!");

//        Scanner scan = new Scanner(System.in);
        BookStorage.writeToFile(scan);

        ArrayList<LibBooks> readFromFile = BookStorage.readFromFile();
        for (int i = 0; i < readFromFile.size(); i++) {
            String b = readFromFile.get(i).getTitle();
            String a = readFromFile.get(i).getAuthor();
            System.out.println("\"" + b + "\"" + " by " + a);
        }
        BookStorage.readFromFile();
        System.out.println();
    }
}
