import java.util.Scanner;

public class TollBooth {
    record Vehicle(String number, String type) {}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        while (true) {
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            String type = sc.next();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type().toLowerCase()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };

            total += toll;

            if (v.type().equalsIgnoreCase("bike")) {
                bike++;
            } else if (v.type().equalsIgnoreCase("car")) {
                car++;
            } else if (v.type().equalsIgnoreCase("truck")) {
                truck++;
            }
        }

        String mostFrequent;

        if (car >= bike && car >= truck) {
            mostFrequent = "car";
        } else if (bike >= car && bike >= truck) {
            mostFrequent = "bike";
        } else {
            mostFrequent = "truck";
        }

        System.out.println("Total toll: " + total);
        System.out.println("Most frequent: " + mostFrequent);
    }
}