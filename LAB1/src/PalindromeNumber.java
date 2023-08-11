import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write -1 to quit");
            System.out.print("Enter a 7-digit number: ");
            int inputNumber = scanner.nextInt();

            if (inputNumber == -1) {
                System.out.println("Program is terminating");
                break;
            }

            if (isValidNumber(inputNumber)) {
                if (isPalindrome(inputNumber)) {
                    System.out.println(inputNumber + " is a palindrome!!!");
                } else {
                    System.out.println(inputNumber + " is not a palindrome.");
                }
            } else {
                System.out.println("Number must be 7 digits.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static boolean isValidNumber(int number) {
        String numberStr = Integer.toString(number);
        return numberStr.length() == 7;
    }

    private static boolean isPalindrome(int number) {
        String numberStr = Integer.toString(number);
        int length = numberStr.length();

        for (int i = 0; i < length / 2; i++) {
            if (numberStr.charAt(i) != numberStr.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
