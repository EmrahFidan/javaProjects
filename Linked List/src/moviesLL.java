import java.util.Scanner;

public class moviesLL {

	// I created a node structure
	static class Node {

		String movieName;
		String movieDirectory;
		String movieCategory;
		double movieIMDBrate;

		Node next;

		// constructor
		public Node(String movieName, String movieDirectory, String movieCategory, double movieIMDBrate) {
			
			this.movieName = movieName;
			this.movieDirectory = movieDirectory;
			this.movieCategory = movieCategory;
			this.movieIMDBrate = movieIMDBrate;

			next = null;

		}
	}

	// I created my Linked list
	static class MyLinkedList {

		Node head = null;
		Node tail = null;
		// temporary node
		Node temp = null;
		Node temp2 = null;

		String movieName;
		String movieDirectory;
		String movieCategory;
		double movieIMDBrate;
		
		Scanner scanner = new Scanner(System.in);

		// add elements to the list
		void add() {
			
			System.out.print("MovieName: ");
			String movieName = scanner.nextLine();
			
			System.out.print("MovieDirectory: ");
			String movieDirectory = scanner.nextLine();
			
			System.out.print("MovieCategory: ");
			String movieCategory = scanner.nextLine();
			
			System.out.print("MovieIMDBrate: ");
			double movieIMDBrate = scanner.nextDouble();
			
			
			Node newNode = new Node(movieName, movieDirectory, movieCategory, movieIMDBrate);

			// if the list is empty 
			if (head == null) {
				head = newNode;
				tail = newNode;
				System.out.println();
				System.out.println("First movie is added");
			} 
			
			else {
				// control
				if(movieName.equalsIgnoreCase(head.movieName)) {
					System.out.println("Bu film zaten kayitli...");
					head = head.next;
					return;
				}
				// add it as the last element
				else {
			            tail.next = newNode;
			            tail = newNode;
				}
				
			}

			// adding in alphabetical order
			
			Node current = head,
			temp2 = null;
			 
	        String name;
	        String directory;
	        String category;
	        double ımdb;
	 
	        if (head == null) {
	            return;
	        }
	        else {
	            while (current != null) {
	                
	                temp2 = current.next;
	                int compare = current.movieName.compareTo(movieName);
	                
	                while (temp2 != null) {
	                    // the location of each entered value must be changed
	                    if (compare > 0) {
	                        name = current.movieName;
	                        directory = current.movieDirectory;
	                        category = current.movieCategory;
	                        ımdb = current.movieIMDBrate;
	                        
	                        current.movieName = temp2.movieName;
	                        current.movieDirectory = temp2.movieDirectory;
	                        current.movieCategory = temp2.movieCategory;
	                        current.movieIMDBrate = temp2.movieIMDBrate;
	                        
	                        temp2.movieName = name;
	                        temp2.movieDirectory = directory;
	                        temp2.movieCategory = category;
	                        temp2.movieIMDBrate = ımdb;
	                    }
	 
	                    temp2 = temp2.next;
	                }
	                current = current.next;
	            }
	        }
	}

		// remove elements to the list
		void delete() {
			// if the list is empty
			if (head == null) {
				System.out.println("empty list, added  please !!!");
			} else {
				System.out.println("Movie Name for delete: ");
				movieName = scanner.nextLine();
				// if there is a movie on the list and we want to delete it
				if (movieName.equalsIgnoreCase(head.movieName)&& head.next == null) {
					
					head = null;
					tail = null;
					System.out.println("movies list is empty !!!");

				} 
				// there are more than one movie in the list but I want to delete the first element
				else if (movieName.equalsIgnoreCase(head.movieName) && head.next != null) {
					
					head = head.next;
					System.out.println("movie named" + movieName + "has been deleted");
				} 
				else {
					// elimination
					temp = head;
					temp2 = head;
					while (temp.next != null) {
						if (movieName.equalsIgnoreCase(temp.movieName)) {
							temp2.next = temp.next; 
							System.out.println("movie named" + movieName + "has been deleted");
						}
						temp2 = temp;
						temp = temp.next;
					}
					// removing the last element
					if (movieName.equalsIgnoreCase(temp.movieName)) {
						temp2.next = null; 
						tail = temp2;
						System.out.println("movie named" + movieName + "has been deleted");
					}
				}
			}
		}		

		// print all movies
		void print() {
			
			if(head == null) {
				System.out.println("movies list empty !!!");
			}
			else {
				temp = head;
				int movieID = 0;
				while(temp != null) {
					
					movieID++;
					System.out.println("--------------------------------");
					System.out.println("MoiveID: "+movieID);
					System.out.println("MoiveName: "+temp.movieName);
					System.out.println("MoiveDirectory: "+temp.movieDirectory);
					System.out.println("MoiveCategory: "+temp.movieCategory );
					System.out.println("MoiveIMDBrate: "+temp.movieIMDBrate);
					
					temp = temp.next;
				}
			}	
		}

}
	
// User interface 
public static void mainMenu(MyLinkedList movies) {
		
	Scanner value = new Scanner(System.in);
		System.out.println("\nMain Menu\n1: Add New Movie\n2: Remove Movie\n3: Print all movies\n0: exit\n");
		System.out.print("enter a choice: ");
		String Choice = value.nextLine();
		String choice = String.valueOf(Choice);
		
		if(choice.equals("1")) {
			System.out.println();
			movies.add();
			mainMenu(movies);
		}
		else if(choice.equals("2")) {
			System.out.println();
			movies.delete();
			mainMenu(movies);
		}
		else if(choice.equals("3")) {
			System.out.println();
			movies.print();
			mainMenu(movies);
			
		}
		else if(choice.equals("0")) {
			System.out.println();
			System.out.println("Program terminating...");
			// return;
		}
		else {
			System.out.println();
			System.out.println("Invalid choice [0-3]");
			System.out.println();
			mainMenu(movies);
		}
		value.close();
	}

public static void main(String[] args) {
	
		// I have created a new list
		MyLinkedList movies = new MyLinkedList(); 
		
		mainMenu(movies);

	}

}
