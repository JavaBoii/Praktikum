package zettel_8;

public class AlumniMustNotReceiveSalaryException extends Exception {
    private Employee employee;

    public AlumniMustNotReceiveSalaryException(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String getMessage() {
        return "Cannot pay salary to alumni employee: " + employee.getName();
    }
}