package application;

public class SalariedEmployee extends Employee{

	private double weeklySalary;

	public SalariedEmployee(String firstName, String lastName, String SocialSocurityNumber, double weeklySalary) {
		super(firstName, lastName, SocialSocurityNumber);
		setWeeklySalary(weeklySalary);
	}
	
	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}

	@Override
	public String toString() {
		return "saalaried employee : " + super.toString() + "\nweekly salary : $" + getWeeklySalary() +
				"\npayment amount : $" + getPaymentAmount();
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}


	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary > 0)
			this.weeklySalary = weeklySalary;
		else {
			System.out.println("involid weeklySalary");
		}
		
	}

	
	
	
}
