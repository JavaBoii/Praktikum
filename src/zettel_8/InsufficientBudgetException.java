package zettel_8;

public class InsufficientBudgetException extends Exception {
    private double amount;
    private Employee employee;

    public InsufficientBudgetException(Employee employee, double amount) {
        this.employee = employee;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String getMessage() {
        return "Insufficient budget to pay employee " + employee.getName() + ". Amount missing: " + amount;
    }
}