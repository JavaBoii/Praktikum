package zettel_4;

public class AnimalFeed {
    private String name;
    private double amount;

    public AnimalFeed(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AnimalFeed [name=" + name + ", amount=" + amount + "]";
    }
}
