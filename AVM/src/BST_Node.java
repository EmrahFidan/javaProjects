
public class BST_Node {

	int barcodeNumber;
	String productName;
	int quantity;
	
	BST_Node right; // pointer
	BST_Node left; // pointer
	
	// constructor
	public BST_Node(int barcodeNumber,String productName, int quantity) {
		this.barcodeNumber = barcodeNumber;
		this.productName = productName;
		this.quantity = quantity;
		
		left = null;
		right = null;
	}
	
}
