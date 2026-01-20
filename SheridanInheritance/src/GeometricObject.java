import java.util.Date; 


public class GeometricObject {
    private String color; 
    private Boolean filled; 
    private java.util.Date dateCreated; 

   
    public GeometricObject() {
        this.color = "White";
        this.filled = false;
        this.dateCreated = new Date();
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return this.dateCreated;
    }

    public String toString() {
        return "Color: " + this.color + " Filled: " + this.filled + " Date Created: " + this.dateCreated;
    }
}