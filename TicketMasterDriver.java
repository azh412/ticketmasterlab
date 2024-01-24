import java.util.Scanner;

public class TicketMasterDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t*** Welcome to the Ticket Master Kiosk ***");
        System.out.println("You may search our shows by city as well as by performer and by ticket price");
        System.out.println("\tSimply select the correct option corresponding with your choice");
        String userInput = scanner.nextLine();
        while(!isNumeric(userInput) || Integer.parseInt(userInput) > 6){
            System.out.println("Invalid entry. Please provide an integer 1-6");
        }
        while()
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
