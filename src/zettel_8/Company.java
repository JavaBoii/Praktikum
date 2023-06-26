package zettel_8;

import styl.Styling;

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
        System.out.format("| %-30s | %-22s | %s |\n", "Status", "Employee", "Result");
        System.out.format("| %-30s | %-22s | %s |\n", "------------------------------", "---------------", "------");
        for (Employee employee : employees) {
            try {
                paymentProcessor.processPayment(employee);
            } catch (InsufficientBudgetException e) {
                System.out.print(Styling.RED + "| " + String.format("%-30s", "Insufficient budget") + " | ");
                System.out.print(String.format("%-22s", employee.getName()) + " |   ");
                System.out.println(String.format("%s", "❌") + "   |" + Styling.RESET);
            } catch (AlumniMustNotReceiveSalaryException e) {
                System.out.print(Styling.RED + "| " + String.format("%-30s", "Cannot pay alumni") + " | ");
                System.out.print(String.format("%-22s", employee.getName()) + " |   ");
                System.out.println(String.format("%s", "❌") + "   |" + Styling.RESET);
            }
        }
    }
}