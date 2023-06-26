package zettel_8;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees;
    private double budget;
    private PaymentProcessor paymentProcessor;

    public Company(double budget) {
        this.budget = budget;
        this.employees = new ArrayList<>();
        this.paymentProcessor = new PaymentProcessor(budget);
    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void payEmployees() {
        for (Employee employee : employees) {

            try {
                paymentProcessor.processPayment(employee);
            } catch (InsufficientBudgetException e) {
                System.out.println(e.getMessage());
            } catch (AlumniMustNotReceiveSalaryException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}