package zettel_4;

public class Herbivore extends Animal {
    public Herbivore(String name, int age) {
        super(name, age);
    }

    @Override
    public void feed(AnimalFeed food) {
        if (food instanceof VegetableFeed) {
            System.out.println(this.getName() + " is feeding on " + food.getName() + ".");
        } else {
            System.out.println(this.getName() + " cannot feed on " + food.getName() + ".");
        }
    }

    @Override
    public String toString() {
        return "Herbivore [" + super.toString() + "]";
    }
}
