package zettel_4;

public class Scavenger extends Animal {
    public Scavenger(String name, int age) {
        super(name, age);
    }

    @Override
    public void feed(AnimalFeed food) {
        if (food instanceof CarnalAnimalFeed && ((CarnalAnimalFeed) food).isDead()) {
            System.out.println(this.getName() + " is feeding on the remains of " + food.getName() + ".");
        } else {
            System.out.println(this.getName() + " cannot feed on " + food.getName() + ".");
        }
    }

    @Override
    public String toString() {
        return "Scavenger [" + super.toString() + "]";
    }
}
