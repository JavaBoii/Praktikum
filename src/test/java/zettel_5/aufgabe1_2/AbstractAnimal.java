package zettel_5.aufgabe1_2;

public abstract class AbstractAnimal {

    protected String name;
    protected int age;
    public AbstractAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void makeSound();
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
    }
}
