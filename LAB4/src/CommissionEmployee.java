public class CommissionEmployee {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                              double grossSales, double commissionRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    public double earning() {
        return grossSales * commissionRate;
    }

    @Override
    public String toString() {
        return "First Name = " + getFirstName() + " Last Name = " + getLastName() +
                " Social Security Number = " + getSocialSecurityNumber() + " Gross Sales = " + getGrossSales() +
                " Commission Rate = " + getCommissionRate() + "\n" + " Earning = " + earning() + "\n";
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales >= 0) {
            this.grossSales = grossSales;
        }
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate >= 0 && commissionRate <= 1) {
            this.commissionRate = commissionRate;
        }
    }
}
