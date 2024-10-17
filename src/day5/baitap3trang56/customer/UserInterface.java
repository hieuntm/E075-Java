package day5.baitap3trang56.customer;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        CDCreator cdCreator = new CDCreator();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add movie");
            System.out.println("2. Add music");
            System.out.println("3. Display all movie");
            System.out.println("4. Display all music");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    cdCreator.addMovie();
                    break;
                case 2:
                    cdCreator.addMusic();
                    break;
                case 3:
                    cdCreator.displayAllMovie();
                    break;
                case 4:
                    cdCreator.displayAllMusic();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (true);
    }
}
