import java.util.Scanner;

public class Tree {
	
	static BST_Node root;
	BST_Node tmp;

	// constructor
	public Tree() {
		root = null;
	}

	BST_Node newNode(int barcodeNumber,String productName, int quantity) {
		root = new BST_Node(barcodeNumber, productName, quantity);
		return root;
	}
	
	BST_Node add(BST_Node root, int barcodeNumber,String productName, int quantity) {
	
		if (root != null) {
			
			if (barcodeNumber < root.barcodeNumber) {
				root.left = add(root.left, barcodeNumber ,productName, quantity);
			} else {
				root.right = add(root.right, barcodeNumber ,productName, quantity);
			}
		} else {
			root = newNode(barcodeNumber ,productName, quantity);
		}

		return root;
	}
	
	
	boolean search(int barcodeNumber)  { 
		tmp  = NFT(root, barcodeNumber); 
        if (tmp!= null)
            return true;
        else
            return false;
    }
	
    BST_Node NFT (BST_Node root, int barcodeNumber)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.barcodeNumber==barcodeNumber) 
            return root; 
        // val is greater than root's key 
        if (root.barcodeNumber > barcodeNumber) 
            return NFT(root.left, barcodeNumber); 
        // val is less than root's key 
        return NFT(root.right, barcodeNumber); 
    } 
    

	

	BST_Node increaseQuantity (BST_Node root, int BN1) {
		Scanner input = new Scanner(System.in);
		
		if(root != null) {
			if(root.barcodeNumber == BN1) {
				System.out.print("Quantity to increase: ");
				int stock = input.nextInt();
				root.quantity = root.quantity + stock;
			}
			else if (BN1 < root.barcodeNumber) {
				root.left = increaseQuantity(root.left, BN1);
			} else {
				root.right = increaseQuantity(root.right, BN1);
			}
		}
		return root;
		
	}
	
	BST_Node decreaseQuantity (BST_Node root,int BN2) {
		Scanner input = new Scanner(System.in);
		
		if(root != null) {
			if(root.barcodeNumber == BN2) {
				System.out.print("Quantity to decrease: ");
				int stock = input.nextInt();
				root.quantity = root.quantity - stock;
			}
			else if (BN2 < root.barcodeNumber) {
				root.left = decreaseQuantity(root.left, BN2);
			} else {
				root.right = decreaseQuantity(root.right, BN2);
			}
		}
		return root;
		
	}
		
	
	// preOrder -> Node, Left, Right
	void preOrder(BST_Node root) {
		if(root != null) {
			System.out.println("Barcode Number -> " + root.barcodeNumber + "\nProduct Name   -> '" + 
				root.productName + "'\nQuantity       -> " + root.quantity + "\n---------------------");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	// inOrder -> Left, Node, Right
	void inOrder(BST_Node root) {
		if(root != null) {
			
			inOrder(root.left);
			System.out.println("Barcode Number -> " + root.barcodeNumber + "\nProduct Name   -> '" + 
				root.productName + "'\nQuantity       -> " + root.quantity + "\n---------------------");
			inOrder(root.right);
		}
	}
	
	// postOrder -> Left, Right, Node
	void postOrder(BST_Node root) {
		if(root != null) {
			
			postOrder(root.left);
			postOrder(root.right);
			System.out.println("Barcode Number -> " + root.barcodeNumber + "\nProduct Name   -> '" + 
				root.productName + "'\nQuantity       -> " + root.quantity + "\n---------------------");
		}
	}
	
}
