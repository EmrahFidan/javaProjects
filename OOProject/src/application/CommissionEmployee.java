package application;

public class CommissionEmployee extends Employee{

	private double grossSales;
	private double commissionRate;
	
	// constructor
	public CommissionEmployee(String firstName, String lastName, String SocialSocurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, SocialSocurityNumber);
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
	}
	
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		if(grossSales >= 0)
			this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		if(commissionRate > 0 && commissionRate < 1)
			this.commissionRate = commissionRate;
	}

	@Override
	public double getPaymentAmount() {
		return getCommissionRate() * getGrossSales();
	}

	@Override
	public String toString() {
		return "commission employee : " + super.toString() + "\ngross sales : $" + getGrossSales() +
				"  commission rate : " + getCommissionRate() + "\npayment amount : $" + getPaymentAmount();
	}
	
}
