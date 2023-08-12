import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter weight and height (separated by space):");
			String input = scanner.nextLine();

			try {
			    String[] inputs = input.split(" ");
			    double weight = Double.parseDouble(inputs[0]);
			    double height = Double.parseDouble(inputs[1]);

			    double weightInKilos = convertPoundsToKilos(weight);
			    double heightInMeters = convertInchesToMeters(height);

			    double bmi = calculateBMI(weightInKilos, heightInMeters);

			    System.out.println();
			    System.out.println("BMI is: " + bmi);
			    printBMIStatus(bmi);

			} catch (NumberFormatException e) {
			    System.out.println("Input error: Please enter valid weight and height.");
			}
		}
    }

    private static double convertPoundsToKilos(double pounds) {
        return 0.45359237 * pounds;
    }

    private static double convertInchesToMeters(double inches) {
        return 0.0254 * inches;
    }

    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    private static void printBMIStatus(double bmi) {
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25.0) {
            System.out.println("Normal");
        } else if (bmi < 30.0) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
