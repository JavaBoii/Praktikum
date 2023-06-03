package zettel_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create spherical list around (100.0, 100.0, 100.0)
        var sphericalList = new SphericalList<Person, Double>(
                new Point<Double>( 100.0, 100.0, 100.0)
        );
        // Create some persons and place them into the sphere
        var bob = new Person("Bob", 23);
        var alice = new Person("Alice", 21);
        var charles = new Person("Charles", 23);
        var dave = new Person("Dave", 22);
        sphericalList.add(
                new SphericalElement<>(bob, new Point<Double>(100.0, 100.0, 100.0))
        );
        sphericalList.add(
                new SphericalElement<>(alice, new Point<Double>(150.0, 100.0, 100.0))
        );
        sphericalList.add(
                new SphericalElement<>(charles, new Point<Double>(90.0, 90.0, 100.0))
        );
        sphericalList.add(
                new SphericalElement<>(dave, new Point<Double>(105.0, 101.0, 100.0))
        );
        // Print all elements sorted by distance to center of sphere
        sphericalList.printInsideOut();
        // Let user enter radius
        var scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        var radius = scanner.nextDouble();
        // Out all persons within radius
        System.out.println("All persons within radius " + radius);
        for(var person : sphericalList.getElementsWithinRadius(radius)) {
            System.out.println("- " + person);
        }
    }
}
