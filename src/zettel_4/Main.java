package zettel_4;

public class Main {
    public static void separator(int length) {
        System.out.print("\n#");
        for (int i = 0; i < length - 2; i++) {
            System.out.print("----");
        }
        System.out.println("#\n");
    }

    public static void main(String[] args) {
        Animal lion = new Carnivore("Lion", 10, 90);
        Animal vulture = new Scavenger("Vulture", 5);
        Animal rabbit = new Herbivore("Rabbit", 2);

        AnimalFeed vegetableFeed = new VegetableFeed("Carrot", 1.0, "Root");
        AnimalFeed liveFeed = new CarnalAnimalFeed("Mouse", 0.5, false, 50);
        AnimalFeed deadFeed = new CarnalAnimalFeed("Dead Deer", 30.0, true, 0);

        System.out.println();
        separator(33);
        System.out.println(lion);
        separator(33);
        System.out.println(vulture);
        separator(33);
        System.out.println(rabbit);
        separator(33);
        System.out.println(vegetableFeed);
        separator(33);
        System.out.println(liveFeed);
        separator(33);
        System.out.println(deadFeed);
        separator(33);

        lion.feed(liveFeed);
        separator(33);
        vulture.feed(deadFeed);
        separator(33);
        rabbit.feed(vegetableFeed);
        separator(33);

        lion.feed(vegetableFeed);
        separator(33);
        vulture.feed(liveFeed);
        separator(33);
        rabbit.feed(deadFeed);
        separator(33);
    }
}
