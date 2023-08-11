import java.util.Scanner;

public class CreateFigure {

    public static void main(String[] args) {

        while (true) {

            int space = 0;
            // Taking input from the user
            Scanner value = new Scanner(System.in); // To take input from the user
            System.out.println("Type 'q' to exit");
            System.out.print("Please enter a positive integer:");
            String number = value.nextLine();

            System.out.println("Value:" + number);
            System.out.println("--------------");
            // Exit when 'q' is entered
            if (number.equals("q")) {
                System.out.println("Program is terminating");
                break; // End of code
            } else {
                int n = Integer.parseInt(number); // Value should be an integer for the rest of the code

                for (int i = n; i > 0; i = i - 2) { // Upper part of the shape

                    for (int j = 0; j < space; j++) {
                        System.out.print(" "); // Leading spaces on each line
                    }

                    space += 1;
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println(); // To move to the next line
                }

                if (n % 2 == 0) { // Check for odd-even (even case)
                    space -= 1;
                    for (int i = 2; i <= n; i = i + 2) {

                        for (int j = 0; j < space; j++) {
                            System.out.print(" ");
                        }

                        space -= 1;

                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                } else { // Odd case
                    space -= 2;
                    for (int i = 3; i <= n; i = i + 2) {

                        for (int j = 0; j < space; j++) {
                            System.out.print(" ");
                        }

                        space -= 1;

                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
