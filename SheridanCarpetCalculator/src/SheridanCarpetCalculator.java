import java.util.Scanner;

public class SheridanCarpetCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Continuously prompt the user until they choose to end
        while (true) {
            System.out.print("Enter the length of the room (in feet): ");
            double length = input.nextDouble();
            
            System.out.print("Enter the width of the room (in feet): ");
            double width = input.nextDouble();
            
            System.out.print("Enter the cost of carpet per square foot: $");
            double carpetCost = input.nextDouble();
            
            // Validate input 
            if (length <= 0 || width <= 0 || carpetCost <= 0) {
                System.out.println("Invalid input. Please enter positive values.");
                continue; 
            }

            // Create RoomDimension and RoomCarpet objects
            RoomDimension roomDim = new RoomDimension(length, width);
            RoomCarpet roomCarpet = new RoomCarpet(roomDim, carpetCost);

            // Calculate and display the total cost of carpet
            System.out.println("Total cost of the carpet: $" + roomCarpet.getTotalCost());

            // Ask the user if they want to calculate for another room
            System.out.print("Calculate carpet cost for another room? (y/n): ");
            String anotherRoom = input.next().toLowerCase();
            if (!anotherRoom.equals("y")) {
                System.out.println("Goodbye.");
                break; 
            }
        }

        input.close();
    }
}