package zettel_8;
public class Employee {
    private String name;
    private double accountBalance;
    private double salary;
    private Department department;
    private Status status;

    public enum Department {
        HR, DEVOPS, FINANCE
    }

    public enum Status {
        ACTIVE(true), ON_VACATION(true), ALUMNI(false);

        private final boolean canBePaid;

        Status(boolean canBePaid) {
            this.canBePaid = canBePaid;
        }

        public boolean canBePaid() {
            return canBePaid;
        }
    }

    public Employee(String name, double accountBalance, double salary, Department department) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.salary = salary;
        this.department = department;
        this.status = Status.ACTIVE;
    }

    public Employee(String name, double accountBalance, double salary, Department department, Status status) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.salary = salary;
        this.department = department;
        this.status = status;
    }

    // Getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
