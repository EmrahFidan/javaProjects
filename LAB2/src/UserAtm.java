import java.util.Scanner;

public class UserAtm {

    public static void main(String[] args) {
        int[] balance = new int[10];
        for (int i = 0; i < balance.length; i++) {
            balance[i] = 100;
        }
        int id = exit(balance);
        control(id, balance);
    }

    public static void control(int id, int balance[]) {
        if (id >= 0 && id < balance.length) {
            mainMenu(balance, id);
        } else {
            System.out.println("User not found !!! Please enter between 0-" + (balance.length - 1));
            id = exit(balance);
            control(id, balance);
        }
    }

    public static void mainMenu(int balance[], int id) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMain Menu\n1: check balance\n2: withdraw\n3: deposit\n4: exit\n");
            System.out.print("Enter a choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance(balance, id);
                    break;
                case 2:
                    withdraw(balance, id);
                    break;
                case 3:
                    deposit(balance, id);
                    break;
                case 4:
                    exit(balance);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }

    public static void checkBalance(int balance[], int id) {
        System.out.println("\nThe balance is: " + balance[id]);
    }

    public static void withdraw(int balance[], int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter an amount to withdraw: ");
        int takeBalance = scanner.nextInt();
        if (takeBalance <= balance[id]) {
            balance[id] -= takeBalance;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public static void deposit(int balance[], int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter an amount to deposit: ");
        int deposit = scanner.nextInt();
        balance[id] += deposit;
    }

    public static int exit(int balance[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an id: ");
        int id = scanner.nextInt();
        return id;
    }
}
