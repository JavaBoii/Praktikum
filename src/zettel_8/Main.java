package zettel_8;

import java.io.*;
import java.util.*;
import java.text.NumberFormat;
public class Main {
    public static void main(String[] args) {

        Company company = new Company(120000.99);
        //hello testo bullshitto

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/zettel_8/employees.csv"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String name = parts[0];
                    double accountBalance = Double.parseDouble(parts[1]);
                    double salary = Double.parseDouble(parts[2]);
                    Employee.Department department = Employee.Department.valueOf(parts[3].toUpperCase());

                    Employee employee = new Employee(name, accountBalance, salary, department);
                    company.addEmployee(employee);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the employees
        List<Employee> employees = company.getEmployees();

        // Initialize a Random object
        Random random = new Random();

        // Iterate over the employees and randomly assign them a status
        for (Employee employee : employees) {
            int status = random.nextInt(85); // generate a random integer from 0 to 85
            if (status < 5) { // approx. 5% chance to fire an employee
                employee.setStatus(Employee.Status.ALUMNI);
            } else if (status >= 5 && status < 25) { // approx. 20% chance to put an employee on vacation
                employee.setStatus(Employee.Status.ON_VACATION);
            }
            // there's a 75% chance the employee's status remains ACTIVE
        }

        // Pay the employees
        company.payEmployees();

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY); // Germany uses period as a thousand separator

        String formattedBudget = nf.format(Double.valueOf(company.getPaymentProcessor().getAvailableBudget()).longValue());
        String formattedFunds = nf.format(Double.valueOf(company.getFunds()).longValue());

        System.out.println("Remaining budget: " + formattedBudget + "€" + "\nFunds needed: " + formattedFunds + "€");
    }
}