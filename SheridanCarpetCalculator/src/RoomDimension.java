
public class RoomDimension {
    private double length;
    private double width;

    // Constructor
    public RoomDimension(double len, double w) {
        length = len;
        width = w;
    }

    // Method to return area of the room
    public double getArea() {
        return length * width;
    }

    // String representation of room 
    @Override
    public String toString() {
        return "Length: " + length + " feet, Width: " + width + " feet";
    }
}
