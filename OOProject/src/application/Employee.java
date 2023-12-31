package application;

public abstract class Employee implements Payable{

	private String firstName;
	private String lastName;
	private String SSN;
	
	public abstract double getPaymentAmount();
	
	// constructor
	
	public Employee(String firstName, String lastName, String SocialSocurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = SocialSocurityNumber;
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " +getLastName() + " " +getSSN();
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	
}
