public class HourlyEmployee extends Employee {

    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);
        setWage(wage);
        setHours(hours);
    }

    public double getPaymentAmount() {
        double paymentAmount;

        if (hours <= 40) {
            paymentAmount = wage * hours;
        } else {
            paymentAmount = (40 * wage) + ((hours - 40) * (wage * 1.5));
        }
        return paymentAmount;
    }

    public String toString() {
        return "Hourly employee: " + super.toString() + "\nHourly wage: $" + wage +
                ", Hours worked: " + hours + "\nPayment amount: $" + getPaymentAmount();
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        if (wage >= 0) {
            this.wage = wage;
        }
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        if (hours >= 0 && hours < 168) {
            this.hours = hours;
        }
    }
}
