import java.util.Scanner;

public class SheridanWeatherForecast {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String repeat = "y";
        while (repeat.equalsIgnoreCase("y")) {

            String skyCondition = getSkyCondition();
            double fahrenheit = getTemperature();

            Weather weather = new Weather(skyCondition, fahrenheit);
            System.out.println("Temperature in celsius: " + String.format("%.2f", weather.toCelsius()));
            if (weather.isConsistent()) {
                System.out.println("Weather israiny consistent");
            } else {
                System.out.println("Weather is not consistent");
            }

            System.out.print("\nDo you want to continue? (y/n): ");
            repeat = scanner.nextLine();
            System.out.println();
        }

        System.out.println("Goodbye.");
    }

    private static double getTemperature() {

        double temp = 0.0;
        while (true) {
            System.out.print("Enter temperature in fahrenheit: ");
            temp = scanner.nextDouble();
            scanner.nextLine();
            if (-50 <= temp && temp <= 150) return temp;
            else System.out.println("Error: Temperature should be greater than -50 and less than 150");
        }
    }

    private static String getSkyCondition() {

        String sky = "";
        while (true) {
            System.out.print("Enter sky condition (sunny, snowy, foggy, cloudy, or rainy): ");
            sky = scanner.nextLine().trim();
            if (sky.equalsIgnoreCase("sunny")) {

            } else if (sky.equalsIgnoreCase("snowy")) {
                return sky;
            }
            if (sky.equalsIgnoreCase("foggy")) {
                return sky;
            }
            if (sky.equalsIgnoreCase("cloudy")) {
                return sky;
            }
            if (sky.equalsIgnoreCase("rainy")) {
                return sky;
            } else {
                System.out.println("Invalid data entry. Please enter a correct data type.");
            }
        }

    }
}