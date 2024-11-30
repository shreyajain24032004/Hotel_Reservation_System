import java.util.Scanner;

public class HotelReservationSystem {

    static String[] rooms = {"Single Room", "Double Room", "Suite"};
    static double[] prices = {100.0, 150.0, 250.0}; // Prices for each room type
    static boolean[] roomAvailability = {true, true, true}; // Availability of rooms (true means available)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to the Hotel Reservation System!");

        while (isRunning) {
            System.out.println("\nAvailable Rooms:");
            for (int i = 0; i < rooms.length; i++) {
                if (roomAvailability[i]) {
                    System.out.println((i + 1) + ". " + rooms[i] + " - $" + prices[i]);
                } else {
                    System.out.println((i + 1) + ". " + rooms[i] + " - Unavailable");
                }
            }

            System.out.print("\nEnter the room number to book (1-3), or 0 to exit: ");
            int roomChoice = scanner.nextInt();

            if (roomChoice == 0) {
                System.out.println("Thank you for using the Hotel Reservation System! Goodbye.");
                isRunning = false;
            } else if (roomChoice < 1 || roomChoice > 3) {
                System.out.println("Invalid room number! Please choose a valid option.");
            } else {
                int roomIndex = roomChoice - 1;

                if (roomAvailability[roomIndex]) {
                    // Room is available
                    System.out.print("Enter your name: ");
                    scanner.nextLine();  // Consume the newline character
                    String name = scanner.nextLine();

                    System.out.print("Enter the number of nights: ");
                    int nights = scanner.nextInt();

                    double totalAmount = prices[roomIndex] * nights;
                    System.out.println("Booking " + rooms[roomIndex] + " for " + name + ".");
                    System.out.println("Total amount: $" + totalAmount);
                    
                    System.out.print("Do you want to confirm the reservation (yes/no)? ");
                    String confirm = scanner.next();

                    if (confirm.equalsIgnoreCase("yes")) {
                        roomAvailability[roomIndex] = false; // Mark room as reserved
                        System.out.println("Reservation confirmed! Thank you for booking with us.");
                    } else {
                        System.out.println("Reservation not confirmed. You can choose another room.");
                    }
                } else {
                    System.out.println("Sorry, the room is not available.");
                }
            }
        }

        scanner.close();
    }
}
