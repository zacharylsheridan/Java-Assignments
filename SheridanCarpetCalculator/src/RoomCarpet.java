
public class RoomCarpet {
    private RoomDimension size;
    private double carpetCost;

    // Constructor
    public RoomCarpet(RoomDimension dim, double cost) {
        size = dim;
        carpetCost = cost;
    }

    // Method to return total cost of carpet
    public double getTotalCost() {
        return size.getArea() * carpetCost;
    }

    // String representation of carpet
    @Override
    public String toString() {
        return "Room Dimension: " + size + ", Carpet Cost per sq. ft.: $" + carpetCost;
    }
}