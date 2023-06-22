package zettel_7.aufgabe1;

/*
Die equals Methode in der gegebenen Person Klasse kann einen Fehler verursachen,
wenn das Objekt o, das ihr als Parameter übergeben wird, nicht vom Typ Person ist.
In diesem Fall würde der Typcast (Person) o eine ClassCastException auslösen.
*/

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person otherPerson = (Person) o;
        return java.util.Objects.equals(name, otherPerson.name) && age == otherPerson.age;
    }
}
