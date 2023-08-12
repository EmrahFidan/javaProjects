public class BMI {
	private String name;
	private int age;
	private double weight;
	private double height;

	public BMI() {
		this("John Black", 25, 100, 50);
	}

	public BMI(String name, double weight, double height) {
		this(name, 20, weight, height);
	}

	public BMI(String name, int age, double weight, double height) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	public static double convertPoundsToKilos(double pounds) {
		return 0.45359237 * pounds;
	}

	public static double convertInchesToMeters(double inches) {
		return 0.0254 * inches;
	}

	public double calculateBMI() {
		double weightInKilos = convertPoundsToKilos(weight);
		double heightInMeters = convertInchesToMeters(height);

		double bmi = weightInKilos / (heightInMeters * heightInMeters);

		return Math.round(bmi);
	}

	public String getStatus() {
		double bmi = calculateBMI();
		if (bmi < 18.5) {
			return "Underweight";
		} else if (bmi < 25.0) {
			return "Normal";
		} else if (bmi < 30.0) {
			return "Overweight";
		} else {
			return "Obese";
		}
	}

	// Getters
	public String get_name() {
		return name;
	}

	public int get_age() {
		return age;
	}

	public double get_weight() {
		return weight;
	}

	public double get_height() {
		return height;
	}

	// Setters
	public void set_name(String name) {
		this.name = name;
	}

	public void set_age(int age) {
		this.age = age;
	}

	public void set_weight(double weight) {
		this.weight = weight;
	}

	public void set_height(double height) {
		this.height = height;
	}
}
