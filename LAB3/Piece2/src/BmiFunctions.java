public class BmiFunctions {

    public static double calculateBMI(double weight, double height) {
        double weightInKilos = 0.45359237 * weight;
        double heightInMeters = 0.0254 * height;
        
        double bmi = weightInKilos / (heightInMeters * heightInMeters);
        return bmi;
    }

    public static String interpretBMI(double bmi) {
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
}
