package zettel_8;

import styl.Styling;

import java.util.*;
import java.text.NumberFormat;

public class Company {
    private List<Employee> employees;
    private double budget;
    private PaymentProcessor paymentProcessor;
    private double funds = 0;

    public Company(double budget) {
        this.budget = budget;
        this.employees = new ArrayList<>();
        this.paymentProcessor = new PaymentProcessor(budget);
    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public double getFunds() {
        return funds;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }

    public static String olo(int counter) {
        if (counter >= 10 && counter < 100) {
            return "  ";
        }
        if (counter >= 100){
            return " ";
        }
        return "   ";
    }

    public void payEmployees() {
        Scanner scanner = new Scanner(System.in);
        System.out.format("    | %-30s | %-22s | %s |\n", "Status", "Employee", "Result");
        System.out.format("    | %-30s | %-22s | %s |\n", "------------------------------", "---------------", "------");

        int counter = 0;
        int input = 0;

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY); // Germany uses period as thousand separator

        for (Employee employee : employees) {
            counter++;
            try {
                paymentProcessor.processPayment(employee, counter);
            } catch (InsufficientBudgetException e) {
                System.out.print(counter + olo(counter) + Styling.YELLOW + "| " + String.format("%-30s", "Insufficient budget") + " | ");
                System.out.print(String.format("%-22s", employee.getName()) + " |   ");
                System.out.print(String.format("%s", "❌") + "   |" + Styling.RESET);
                String formattedAmount = nf.format(e.getAmount());
                System.out.println(" Amount missing: " + formattedAmount + " €");

                funds += e.getAmount();
            } catch (AlumniMustNotReceiveSalaryException e) {
                System.out.print(counter + olo(counter) + Styling.RED + "| " + String.format("%-30s", "Cannot pay alumni") + " | ");
                System.out.print(String.format("%-22s", employee.getName()) + " |   ");
                System.out.println(String.format("%s", "❌") + "   |" + Styling.RESET);
            }

            if (counter % 50 == 0 && input == 0) {
                System.out.println("Do you want to continue? (y/n) or display all remaining employees (a)");
                if (counter != employees.size()) {
                    System.out.println("Remaining employees: " + counter + " / " + employees.size());
                }else {
                    System.out.println("All employees have been processed.");
                    break;
                }

                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("n")) {
                    break;
                }
                if (response.equals("a")) {
                    input = 1;
                }
            }
        }

        scanner.close();
    }
}