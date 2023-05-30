package zettel_4;

public class Carnivore extends Animal {
    private int huntingSkill;

    public Carnivore(String name, int age, int huntingSkill) {
        super(name, age);
        this.huntingSkill = huntingSkill;
    }

    @Override
    public void feed(AnimalFeed food) {
        if (food instanceof CarnalAnimalFeed && !((CarnalAnimalFeed) food).isDead() && this.huntingSkill >= 1.5 * ((CarnalAnimalFeed) food).getEscapeChance()) {
            System.out.println(this.getName() + " has successfully hunted " + food.getName() + ".");
        } else {
            System.out.println(this.getName() + " failed to hunt " + food.getName() + ".");
        }
    }

    public int getHuntingSkill() {
        return huntingSkill;
    }

    public void setHuntingSkill(int huntingSkill) {
        this.huntingSkill = huntingSkill;
    }

    @Override
    public String toString() {
        return "Carnivore [huntingSkill=" + huntingSkill + ", " + super.toString() + "]";
    }
}
