package zettel_8;
public class Main {
    public static void main(String[] args) {

        // Erstellen der Mitarbeiter

        Employee employee1 = new Employee("Ehemaliger hund", 0.0, 2000.0, Employee.Department.HR);
        Employee employee2 = new Employee("Aktiver Mann", 0.0, 2500.0, Employee.Department.DEVOPS);
        Employee employee3 = new Employee("Urlaub Frau", 0.0, 3000.0, Employee.Department.FINANCE);
        Employee employee4 = new Employee("Sarah Brown", 0.0, 4000.0, Employee.Department.HR);
        Employee employee5 = new Employee("David Lee", 0.0, 3500.0, Employee.Department.DEVOPS);
        Employee employee6 = new Employee("Emily Davis", 0.0, 2800.0, Employee.Department.FINANCE);

        // Erstellen des Unternehmens und Hinzufügen der Mitarbeiter

        Company company = new Company(50000.0);
        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);
        company.addEmployee(employee4);
        company.addEmployee(employee5);
        company.addEmployee(employee6);

        //Feuern eines Mitarbeiters

        employee1.setStatus(Employee.Status.ALUMNI);

        // Urlaub eines Mitarbeiters

        employee3.setStatus(Employee.Status.ON_VACATION);


        // Zahlung der Mitarbeiter

        company.payEmployees();

    }
}