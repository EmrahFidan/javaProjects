import java.util.Scanner;

public class productStockTrackingSystem {

	public static void main(String[] args) {
		
		Tree product = new Tree();
		
		product.root = product.add(product.root, 20, "Dalin Sampuan", 15);
		product.root = product.add(product.root, 15, "Biskrem Biskuvi", 38);
		product.root = product.add(product.root, 42, "Soke Un", 5);
		product.root = product.add(product.root, 8, "Filiz Makarna", 18);
		product.root = product.add(product.root, 17, "Erikli Su", 65);
		product.root = product.add(product.root, 55, "Filtre Kahve", 0);
		product.root = product.add(product.root, 87, "Caykur Cay", 15);
		
		Scanner input = new Scanner(System.in);

		int choice = menu();

		while (choice != 0) {
			switch (choice) {

			case 1:
				System.out.print("Barcode Number: ");
				int barcodeNumber = input.nextInt();
				
				input.nextLine();
				
				System.out.print("Product Name: ");
				String productName = input.nextLine();
				
				System.out.print("Quantity: ");
				int quantity = input.nextInt();
				
				
				if( ! product.search(barcodeNumber)) {
					
					product.root = product.add(product.root, barcodeNumber, productName, quantity);
					System.out.println("Product added.");
					
				}
				
				else {
					System.out.println("Already exists...");
				}
				
				
				break;

			case 2:
				System.out.println("In Order: \n---------------------------------------------");
				product.inOrder(product.root);
				System.out.println("\n");
				break;
				
			case 3:
				System.out.println("Pre Order: \n---------------------------------------------");
				product.preOrder(product.root);
				System.out.println("\n");
				break;
				
			case 4:
				System.out.println("Post Order: \n---------------------------------------------");
				product.postOrder(product.root);
				System.out.println("\n");
				break;
				
			case 5:
				System.out.print("Barcode Number for decrease quantity: ");
				int BN1 = input.nextInt();
				product.root = product.increaseQuantity(product.root, BN1);
				System.out.println("\n");
				break;
				
			case 6:
				System.out.print("Barcode Number for decrease quantity: ");
				int BN2 = input.nextInt();
				product.root = product.decreaseQuantity(product.root, BN2);
				System.out.println("\n");
				break;

			case 0:
				System.out.println("Program Terminating...");
				break;

			default:
				System.out.println("invalid choice, please [0-6] ");
				break;
			}
			choice = menu();

		}
	
	}
	
	// yılmaz ,samsun hoca, gözde hoca iyi
	
	private static int menu() {

		Scanner input = new Scanner(System.in);

		System.out.println("AVM APP\n--------");
		System.out.println("1 - Add product");
		System.out.println("2 - Print information of product (in order)");
		System.out.println("3 - Print information of product (pre order)");
		System.out.println("4 - Print information of product (post order)");
		System.out.println("5 - Increase quantity of product");
		System.out.println("6 - Decrease quantity of product");
		System.out.println("0 - Exit\n");
		System.out.print("Your Choices: ");
		int choice = input.nextInt();

		return choice;
	}
	
}
