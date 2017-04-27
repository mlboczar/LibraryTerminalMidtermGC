import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nickk on 4/26/2017.
 */
public class Library {

    private final List<LibBooks> books;

    public Library(List<LibBooks> books) {
        this.books = books;
    }

    public void printAllBooks() {
        ArrayList<LibBooks> readFromFile = BookStorage.readFromFile();
        for (int i = 0; i < readFromFile.size(); i++) {
            String b = readFromFile.get(i).getTitle();
            String a = readFromFile.get(i).getAuthor();
            System.out.println("\"" + b + "\"" + " by " + a);
        }
        System.out.println();
    }

    public void searchByTitle(Scanner scan) {
        System.out.println("Please enter the keyword of the title of the book: ");
        String userInput = scan.nextLine();
        for (LibBooks x: books) {
            if (x.getTitle().contains(userInput)) {
                System.out.println(x);
            }
        }
        System.out.println("Book not found");
    }

    public void searchByAuthor(Scanner scan) {
        System.out.println("Please enter the keyword of the author of the book: ");
        String userInput = scan.nextLine();
        for (LibBooks x: books) {
            if (x.getAuthor().contains(userInput)) {
                System.out.println(x);
            }
        }
        System.out.println("Book not found");
    }

    public void selectABookToCheckOut() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the title of the book you would like to check out: ");
        String userInput = scan.nextLine();
        List <LibBooks> bookList = BookStorage.readFromFile();
        for (LibBooks x : bookList) {
            if (x.getStatus()) {
                if (x.getTitle().equalsIgnoreCase(userInput)) {
                    System.out.println("You have checked out the book!");
                    x.setStatus(false);
                }
            } else System.out.println("This book is already checked out!");
        }
    }

    public void returnABook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the title of the book you would like to return: ");
        String userInput = scan.nextLine();
        if (BookStorage.readFromFile().contains(userInput)) {
            System.out.println("Book has been returned!");
        }

    }

}
