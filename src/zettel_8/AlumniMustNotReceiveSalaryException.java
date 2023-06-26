package zettel_8;

import styl.Styling;

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
        return Styling.RED + "Error: alumni employee " + Styling.CYAN + employee.getName() + Styling.RESET;
    }
}