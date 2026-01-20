public class Weather {

    private String sky;
    private double fahrenheit;

    public Weather() {
        sky = "sunny";
        fahrenheit = 70;
    }

    public Weather(String sky, double fahrenheit) {
        this.sky = sky;
        this.fahrenheit = fahrenheit;
    }

    public double toCelsius() {
        return (fahrenheit - 32) * 1.8;
    }

    public boolean isConsistent() {
        return
                !((fahrenheit > 32 && sky.equalsIgnoreCase("snowy")) || (fahrenheit <= 32 && sky.equalsIgnoreCase("rainy")));
    }
}