import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            String[] nameArray = new String[3];
            int[] ageArray = new int[3];
            double[] weightArray = new double[3];
            double[] heightArray = new double[3];
            String[] interpretArray = new String[3];

            for (int i = 0; i < 3; i++) {
                System.out.println("Enter name, age, weight, height (as space separated): ");
                String input = scan.nextLine();

                String[] inputs = input.split(" ");

                String fullName = inputs[0] + " " + inputs[1];
                nameArray[i] = fullName;

                int age = Integer.parseInt(inputs[2]);
                ageArray[i] = age;

                double weight = Double.parseDouble(inputs[3]);
                weightArray[i] = weight;

                double height = Double.parseDouble(inputs[4]);
                heightArray[i] = height;

                double bmi = BmiFunctions.calculateBMI(weight, height);
                interpretArray[i] = BmiFunctions.interpretBMI(bmi);
                System.out.println();
            }

            for (int i = 0; i < 3; i++) {
                System.out.println("---ENTER PERSON " + (i + 1) + "'S VALUES---");
                System.out.println("** The BMI result for " + nameArray[i] +
                                   " (Age: " + ageArray[i] + " Weight: " + weightArray[i] +
                                   " Height: " + heightArray[i] + ") is");
                System.out.println(interpretArray[i]);
            }
        } catch (Exception e) {
            System.out.println("Invalid input, please restart the program.");
        }
    }
}
