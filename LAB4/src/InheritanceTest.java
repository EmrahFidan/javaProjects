public class InheritanceTest {

    public static void main(String[] args) {

        BasePlusCommissionEmployee BPCE = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-333", 5000.00, 0.04, 300.00);

        System.out.println("Employee information obtained by get methods and earnings: \n");
        System.out.println("First Name = " + BPCE.getFirstName() + " \nLast Name = " + BPCE.getLastName() +
                " \nSocial Security Number = " + BPCE.getSocialSecurityNumber() + " \nGross Sales = " + BPCE.getGrossSales() +
                " \nCommission Rate = " + BPCE.getCommissionRate() + "\nBase Salary = " + BPCE.getBaseSalary()
                + " \nEarning = " + BPCE.earning() + "\n");

        System.out.println("\n");

        BPCE = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-333", 5000.00, 0.04, 1000.00);
        System.out.println("Updated employee information obtained by toString and earnings: \n");
        System.out.println(BPCE.toString());
    }
}
