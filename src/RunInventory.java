import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Author: Kylee Fields
 * Date: 5/22/2021
 * Objective: Write a program that functions as a book inventory, featuring a menu and
 * the ability to add, remove, find, and display books.
 **/

public class RunInventory {
    public static void main(String[] args){
        // initialize inventory class
        Inventory inventory = new Inventory();
        while (true){
            // print menu
            System.out.println("\n****** MENU *****");
            System.out.println("1.Add Book");
            System.out.println("2.Remove Book");
            System.out.println("3.Find Book ");
            System.out.println("4.Display Books");
            System.out.println("9.Exit Program");
            System.out.print("Enter your selection : ");
            // take in user input
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            // choose next action based on user input
            switch (choice){
                case 1:
                    inventory.AddBook();
                    break;
                case 2:
                    inventory.RemoveBook();
                    break;
                case 3:
                    inventory.FindBook();
                    break;
                case 4:
                    inventory.Display();
                    break;
                case 9:
                    System.out.println("\nYou are now exiting the book inventory. Goodbye!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid input\n");
                    break;
            }
        }
    }
}


class Book {
    // initialize id, title, price
    String id;
    String title;
    double price;

    public Book(String id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    // so that book values will print instead of address
    @Override
    public String toString() {
        return "Book[ " +
                "id:'" + id + '\'' +
                ", Title:'" + title + '\'' +
                ", Price" + price +
                ']';
    }
}

class Inventory {
    // initialize hashmap of books
    private final HashMap<String, Book> books;

    public Inventory() {
        this.books = new HashMap<>();
    }

    public void AddBook(){
        try {
            //use scanner to interact with hashmap
            Scanner scanner = new Scanner(System.in);
            System.out.print("What is the book id (integer value)?: ");
            // assign id
            String id = scanner.next();
            // validates if book already exists
            if (books.containsKey(id)) {
                System.out.println(" Book id already exist\n");
                return;
            }
            System.out.print("What is the book price (double value)?: ");
            // assign price
            double price = scanner.nextDouble();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.print("What is the book title?: ");
            // assign title
            String title = scanner.nextLine();
            // declare new book class with assigned variables
            Book newBook = new Book(id, title, price);
            // put new book in hashmap
            books.put(id, newBook);
            System.out.print("\nBook is added\n");
        }
        // input validation
        catch (Exception ex){
            System.out.print("\nInvalid input\n");
        }
    }

    public void RemoveBook(){
        try {
            //use scanner to interact with hashmap
            Scanner scanner = new Scanner(System.in);
            System.out.print("What is the book id (integer value)?: ");
            // assign id
            String id = scanner.next();
            // book does not exist scenario
            if (!books.containsKey(id)) {
                System.out.println(" Book id dose not exist\n");
                return;
            }
            // remove book in hashmap
            books.remove(id);
            System.out.print("\nBook is removed");
        }
        // user input validation
        catch (Exception ex){
            System.out.print("\nInvalid input");
        }
    }

    public void FindBook(){
        try {
            // use scanner to interact with hashmap
            Scanner scanner = new Scanner(System.in);
            System.out.print("What is the book id (integer value)?: ");
            // assign id
            String id = scanner.next();
            // book does not exist scenario
            if (!books.containsKey(id)) {
                System.out.println(" Book id dose not exist\n");
                return;
            }
            // display found book
            System.out.print("\n Book found : "+books.get(id));
        }
        // user input validation
        catch (Exception ex){
            System.out.print("\nInvalid input");
        }
    }

    public void Display(){
        // assign iterator to books map
        Iterator<Book> iterator = books.values().iterator();
        System.out.println("================= Books =================");
        // while there is a next book, print it
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=========================================");
    }
}


