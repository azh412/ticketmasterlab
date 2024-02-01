import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TicketMasterDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t*** Welcome to the Ticket Master Kiosk ***");
        System.out.println("You may search our shows by city as well as by performer and by ticket price");
        System.out.println("\tSimply select the correct option corresponding with your choice\n");
        System.out.println("1. Search by City");
        System.out.println("2. Sort by Performer (A-Z)");
        System.out.println("3. Sort by Performer (Z-A)");
        System.out.println("4. Sort by Price (low - high)");
        System.out.println("5. Sort by Price (high - low)");
        System.out.println("6. Quit\n");
        System.out.println("Enter a value between 1 and 6");
        String userInput = scanner.nextLine();
        while(!isNumeric(userInput) || Integer.parseInt(userInput) > 6){
            System.out.println("Invalid entry. Please provide an integer 1-6");
            userInput = scanner.nextLine();
        }
        TicketMaster ticketMaster = new TicketMaster();
        while(!userInput.equals("6")){
            int userInputNumber = Integer.parseInt(userInput);
            if(userInputNumber == 1){
                System.out.println("What city would you like to search for?");
                String city = scanner.nextLine();
                ArrayList<Show> searchResults = ticketMaster.searchByCity(city);
                ticketMaster.printDivider();
                for (Show result: searchResults) {
                    System.out.println(result);
                }
            }
            if(userInputNumber == 2){
                ArrayList<Show> searchResults = ticketMaster.sortByPerformer();
                ticketMaster.printDivider();
                for (Show result: searchResults) {
                    System.out.println(result);
                }
            }
            if(userInputNumber == 3){
                ArrayList<Show> searchResults = ticketMaster.sortByPerformer();
                Collections.reverse(searchResults);
                ticketMaster.printDivider();
                for (Show result: searchResults) {
                    System.out.println(result);
                }
            }
            if(userInputNumber == 4){
                ArrayList<Show> searchResults = ticketMaster.sortByPrice();
                ticketMaster.printDivider();
                for (Show result: searchResults) {
                    System.out.println(result);
                }
            }
            if(userInputNumber == 5){
                ArrayList<Show> searchResults = ticketMaster.sortByPrice();
                Collections.reverse(searchResults);
                ticketMaster.printDivider();
                for (Show result: searchResults) {
                    System.out.println(result);
                }
            }
            System.out.println("\n1. Search by City");
            System.out.println("2. Sort by Performer (A-Z)");
            System.out.println("3. Sort by Performer (Z-A)");
            System.out.println("4. Sort by Price (low - high)");
            System.out.println("5. Sort by Price (high - low)");
            System.out.println("6. Quit\n");
            System.out.println("Enter a value between 1 and 6");
            userInput = scanner.nextLine();
            while(!isNumeric(userInput) || Integer.parseInt(userInput) > 6){
                System.out.println("Invalid entry. Please provide an integer 1-6");
                userInput = scanner.nextLine();
            }
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
