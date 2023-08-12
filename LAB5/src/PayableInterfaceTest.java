public class PayableInterfaceTest {

    public static void main(String[] args) {

        Payable payableObjects[] = new Payable[6];

        payableObjects[0] = new Invoice("01234", "Seat", 2, 375);
        payableObjects[1] = new Invoice("56789", "Tire", 4, 79.95);
        payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-111", 800.00);
        payableObjects[3] = new HourlyEmployee("Karen", "Price", "222-22-222", 16.75, 40.00);
        payableObjects[4] = new CommissionEmployee("Sue", "Jones", "333-33-333", 10000.00, 0.06);
        payableObjects[5] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-444", 5000.00, 0.04, 300.00);

        System.out.println("Invoices and Employees processed polymorphically:\n");

        for (Payable payable : payableObjects) {
            System.out.println(payable.toString());
            
            if (payable instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee temp = (BasePlusCommissionEmployee) payable;
                double base = temp.getBaseSalary();
                temp.setBaseSalary(base + (base * 0.1));
                System.out.println("New base salary with 10% increase is: " + temp.getBaseSalary());
                System.out.println("Payment amount: " + temp.getPaymentAmount());
            } else {
                System.out.println();
            }
        }

        System.out.println();

        for (int j = 0; j <= 5; j++) {
            System.out.println("Payable object " + j + " is a " + payableObjects[j].getClass().getName());
        }
    }
}
