import java.util.Scanner;

public class BmiTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BMI[] bmiArr = new BMI[3];

		for (int i = 0; i < 3; i++) {
			bmiArr[i] = getInputBmi(scanner);
		}

		for (BMI bmi : bmiArr) {
			printBMIResult(bmi);
		}
	}

	public static BMI getInputBmi(Scanner scanner) {
		System.out.println("Enter name, age, weight, height (as space separated): ");
		String input = scanner.nextLine();
		String[] inputs = input.split(" ");

		BMI bmi;

		if (inputs.length == 5) {
			String name = inputs[0] + " " + inputs[1];
			int age = Integer.parseInt(inputs[2]);
			double weight = Double.parseDouble(inputs[3]);
			double height = Double.parseDouble(inputs[4]);
			bmi = new BMI(name, age, weight, height);
		} else if (inputs.length == 4) {
			String name = inputs[0] + " " + inputs[1];
			double weight = Double.parseDouble(inputs[2]);
			double height = Double.parseDouble(inputs[3]);
			bmi = new BMI(name, weight, height);
		} else {
			bmi = new BMI();
			System.out.println("Invalid input. Using default values.");
		}

		return bmi;
	}

	public static void printBMIResult(BMI bmi) {
		String name = bmi.get_name();
		int age = bmi.get_age();
		double weight = bmi.get_weight();
		double height = bmi.get_height();

		String status = bmi.getStatus();

		System.out.println("** The BMI result for " + name + " ( Age: " + age + " Weight: " + weight + " Height: "
				+ height + ") is\n" + status);
	}
}
