public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        setWeeklySalary(weeklySalary);
    }

    public double getPaymentAmount() {
        return weeklySalary;
    }

    public String toString() {
        return "Salaried employee: " + super.toString() + "\nWeekly salary: $" + weeklySalary +
                "\nPayment amount: $" + getPaymentAmount();
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary > 0) {
            this.weeklySalary = weeklySalary;
        } else {
            System.out.println("Invalid weeklySalary");
        }
    }
}
