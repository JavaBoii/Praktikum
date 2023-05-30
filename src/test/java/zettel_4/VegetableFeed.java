package zettel_4;

public class VegetableFeed extends AnimalFeed {
    private String type;

    public VegetableFeed(String name, double amount, String type) {
        super(name, amount);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VegetableFeed [type=" + type + ", " + super.toString() + "]";
    }
}
