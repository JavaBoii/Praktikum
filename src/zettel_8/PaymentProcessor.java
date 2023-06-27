package zettel_8;

import styl.Styling;

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

    public void processPayment(Employee employee, int counter) throws InsufficientBudgetException, AlumniMustNotReceiveSalaryException {
        if (employee.getStatus() == Employee.Status.ALUMNI) {
            throw new AlumniMustNotReceiveSalaryException(employee);
        }

        if ((employee.getStatus() == Employee.Status.ACTIVE || employee.getStatus() == Employee.Status.ON_VACATION) && employee.getSalary() <= getAvailableBudget()) {
            employee.setAccountBalance(employee.getAccountBalance() + employee.getSalary());
            availableBudget -= employee.getSalary();
            System.out.print(counter + Company.olo(counter) + Styling.GREEN + "| " + String.format("%-30s", "Paid salary") + " | ");
            System.out.print(String.format("%-22s", employee.getName()) + " |   ");
            System.out.println(String.format("%s", "✔") + "    |" + Styling.RESET);
        } else {
            throw new InsufficientBudgetException(employee, employee.getSalary() - getAvailableBudget());
        }
    }
}