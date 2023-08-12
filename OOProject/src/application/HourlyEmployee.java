package application;

public class HourlyEmployee extends Employee{

	private double wage;
	private double hours;
	
	public HourlyEmployee(String firstName, String lastName, String SocialSocurityNumber, double wage, double hours) {
		super(firstName, lastName, SocialSocurityNumber);
		setWage(wage);
		setHours(hours);
	}
	
	@Override
	public double getPaymentAmount() {
		double x = 0;
		
		if(getHours() <= 40) {
			x=  getWage()*getHours();
		}
		else if(getHours() > 40) {
			x = (40 * getWage()) + (getHours() - 40)*(getWage() * 1.5);
		}
		return x;
	}

	@Override
	public String toString() {
		return "hourly employee : " + super.toString() + "\nhourly wage : $" + getWage() + ","
				+ " hours worked : " + getHours() + "\npayment amount : $" + getPaymentAmount();
	}


	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if(wage >= 0)
			this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		if(hours >= 0 && hours < 168)
			this.hours = hours;
	}
	
}
