public class Triangle extends GeometricObject{
    private double side1; 
    private double side2; 
    private double side3; 

    
    public Triangle() {
        super(); 
        this.side1 = 1.0; 
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    
    public Triangle(double side1, double side2, double side3) {
        super(); 
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

   
    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    public double getArea() {
        double p = (this.side1 + this.side2 + this.side3) / 2; 
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public String toString() {
        return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3: " + this.side3;
    }
}