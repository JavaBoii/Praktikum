package zettel_7;

import zettel_5.aufgabe2.Styling;

import java.util.*;

public class Main {

    public static void progressBar(int speed) {

        Random rand = new Random(); // Random number generator
        int total = 100; // 100%
        int stepSize = rand.nextInt(1, 5); // How much percent each step represents
        int steps = total / stepSize;


        try {
            for (int i = 0; i <= steps; i++) {
                int percent = i * stepSize;

                System.out.print("\r[");
                for (int j = 0; j < i; j++) {
                    System.out.print("█");
                }
                for (int k = i; k < steps; k++) {
                    System.out.print("▒");
                }
                System.out.print("] " + percent + "%");

                Thread.sleep(rand.nextInt(speed)); // Sleep for a random duration up to 1000ms

                if (percent >= 100) {
                    System.out.print("\r[");
                    for (int j = 0; j < i; j++) {
                        System.out.print(Styling.GREEN + "█" + Styling.RESET);
                    }
                    System.out.print("] 100% - Done!");
                    Thread.sleep(1000); // Pause for 1 second when reaching or exceeding 100%
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nProcessing completed.");
    }

    public static void main(String[] args) {
        Musician m1 = new Musician("Alice", 1, new HashSet<>(Arrays.asList("Rock", "Pop")));
        Musician m2 = new Musician("Bob", 4, new HashSet<>(Collections.singletonList("Pop")));
        Musician m3 = new Musician("Charlie", 2, new HashSet<>(Collections.singletonList("Jazz")));
        Musician m4 = new Musician("Dave", 3, new HashSet<>(Arrays.asList("Rock", "Pop")));
        Musician m5 = new Musician("Eve", 2, new HashSet<>(Collections.singletonList("Pop")));
        Musician m6 = new Musician("Frank", 1, new HashSet<>(Arrays.asList("Electronic", "House")));
        Musician m7 = new Musician("Grace", 2, new HashSet<>(Arrays.asList("Rock", "Blues")));
        Musician m8 = new Musician("Heidi", 0, new HashSet<>(Collections.singletonList("Blues")));
        Musician m9 = new Musician("Ivan", 3, new HashSet<>(Collections.singletonList("Jazz")));

        ApplicationProcess process = new ApplicationProcess();

        List<Musician> musicians = Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9);


        progressBar(200);


        // All musicians apply
        for (Musician musician : musicians) {
            process.apply(musician);
        }

        System.out.println("=== Initial Application Status ===");
        printApplicationStatus(process);

        // Create Genre Histogram
        System.out.println("\n=== Genre Histogram Before Processing Applications ===");
        process.createGenreHistogram().forEach((genre, count) -> System.out.println(genre + ": " + count));

        // Process applications
        process.processApplications();

        System.out.println("\n=== Post-Processing Application Status ===");
        printApplicationStatus(process);

        // Print Rejected Applications
        System.out.println("\n=== Rejected Applications ===");
        process.getRejectedApplications().forEach(musician -> System.out.println(musician.getName()));

        // Print Accepted Musicians Sorted by Performances
        System.out.println("\n=== Accepted Musicians Sorted by Performances ===");
        process.getAcceptedMusiciansByPerformances().forEach(musician -> System.out.println(musician.getName() + ": " + musician.getPerformances()));

        // Print Genres of Accepted Musicians
        System.out.println("\n=== Genres of Accepted Musicians ===");
        process.getAcceptedGenres().forEach((genre, count) -> System.out.println(genre + ": " + count));

        // Count Applications of a Specific Genre
        System.out.println("\n=== Count of Pop Applications ===");
        System.out.println(process.countApplicationsOfGenre("Pop"));

        // Create Genre Histogram
        System.out.println("\n=== Genre Histogram ===");
        process.createGenreHistogram().forEach((genre, count) -> System.out.println(genre + ": " + count));
    }

    private static void printApplicationStatus(ApplicationProcess process) {
        int[] status = process.getApplicationStatus();
        System.out.println("Applications in Queue: " + status[0]);
        System.out.println("Accepted Musicians: " + status[1]);
    }
}
