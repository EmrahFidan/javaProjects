public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
            double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        }
    }

    public double getPaymentAmount() {
        return super.getPaymentAmount() + getBaseSalary();
    }

    public String toString() {
        return "Base salaried commission employee: " + getFirstName() + " " + getLastName() + "\n" +
                "Social Security Number: " + getSocialSecurityNumber() + "\nGross sales: $" + getGrossSales() +
                "  Commission rate: " + getCommissionRate() + " Base salary: $" + baseSalary +
                "\nPayment amount: $" + getPaymentAmount();
    }
}
