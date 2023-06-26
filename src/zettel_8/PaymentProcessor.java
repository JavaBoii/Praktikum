package zettel_8;

public class PaymentProcessor {
    private double availableBudget;

    public PaymentProcessor(double availableBudget) {
        this.availableBudget = availableBudget;
    }



    // Getter setter
    public double getAvailableBudget() {
        return availableBudget;
    }

    public void setAvailableBudget(double availableBudget) {
        this.availableBudget = availableBudget;
    }

    public void processPayment(Employee employee) throws InsufficientBudgetException, AlumniMustNotReceiveSalaryException {
        if (employee.getStatus() == Employee.Status.ALUMNI) {
            throw new AlumniMustNotReceiveSalaryException(employee);
        }

        if ((employee.getStatus() == Employee.Status.ACTIVE || employee.getStatus() == Employee.Status.ON_VACATION) && employee.getSalary() <= getAvailableBudget()) {
            employee.setAccountBalance(employee.getAccountBalance() + employee.getSalary());
            availableBudget -= employee.getSalary();
            System.out.println("Paid salary to employee " + employee.getName());
        } else {
            throw new InsufficientBudgetException(employee, employee.getSalary() - getAvailableBudget());
        }
    }
}