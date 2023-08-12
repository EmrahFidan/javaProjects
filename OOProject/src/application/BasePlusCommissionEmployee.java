package application;

public class BasePlusCommissionEmployee extends CommissionEmployee {

	private double baseSalary;

	// constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, String SocialSocurityNumber,
			double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, SocialSocurityNumber, grossSales, commissionRate);
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if(baseSalary > 0)
			this.baseSalary = baseSalary;
	}

	@Override
	public String toString() {
		return "base salaried commission employee : " + getFirstName() + " " +getLastName() + "\nsocial security number : " 
	+getSSN() + "\ngross sales : $" + getGrossSales() +"  commission rate : " + 
				getCommissionRate() + " base salary : $" + getBaseSalary();
	}
	
	// override etmedim sonra bak
	public double getPaymentAmount() {
		return super.getPaymentAmount() + getBaseSalary();
	}
	
}
