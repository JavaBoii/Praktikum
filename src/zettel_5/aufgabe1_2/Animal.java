package zettel_5.aufgabe1_2;

public class Animal extends AbstractAnimal {

    public Animal(String name, int age) {
        super(name, age);
    }

    public void makeSound() {
        System.out.println("Meow!");
    }


}
