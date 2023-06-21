package zettel_7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import styl.Styling;

public class Main {
    public static void main(String[] args) {
        Set<String> genres = new HashSet<>();
        genres.add("Rock");
        genres.add("Pop");
        Musician musician1 = new Musician("John Doe", 2, genres);

        genres = new HashSet<>();
        genres.add("Pop");
        Musician musician2 = new Musician("Jane Doe", 4, genres);

        genres = new HashSet<>();
        genres.add("Jazz");
        Musician musician3 = new Musician("James Dean", 1, genres);

        genres = new HashSet<>();
        genres.add("Rock");
        genres.add("Blues");
        Musician musician4 = new Musician("Tom Smith", 3, genres);

        genres = new HashSet<>();
        genres.add("Pop");
        genres.add("Jazz");
        Musician musician5 = new Musician("Sarah Johnson", 1, genres);

        genres = new HashSet<>();
        genres.add("Folk");
        Musician musician6 = new Musician("Mary Williams", 2, genres);

        genres = new HashSet<>();
        genres.add("Rock");
        Musician musician7 = new Musician("Michael Brown", 3, genres);

        genres = new HashSet<>();
        genres.add("Pop");
        Musician musician8 = new Musician("Emily Davis", 4, genres);

        genres = new HashSet<>();
        genres.add("Jazz");
        genres.add("Blues");
        Musician musician9 = new Musician("David Miller", 1, genres);

        genres = new HashSet<>();
        genres.add("Blues");
        Musician musician10 = new Musician("Jessica Wilson", 2, genres);

        genres = new HashSet<>();
        genres.add("Jazz");
        Musician musician11 = new Musician("Robert Moore", 3, genres);

        genres = new HashSet<>();
        genres.add("Pop");
        Musician musician12 = new Musician("Emma Taylor", 1, genres);

        genres = new HashSet<>();
        genres.add("Rock");
        Musician musician13 = new Musician("William Anderson", 4, genres);



        ApplicationProcess applicationProcess = new ApplicationProcess();
        applicationProcess.acceptApplication(musician1);
        applicationProcess.acceptApplication(musician2);
        applicationProcess.acceptApplication(musician3);
        applicationProcess.acceptApplication(musician4);
        applicationProcess.acceptApplication(musician5);
        applicationProcess.acceptApplication(musician6);
        applicationProcess.acceptApplication(musician7);
        applicationProcess.acceptApplication(musician8);
        applicationProcess.acceptApplication(musician9);
        applicationProcess.acceptApplication(musician10);
        applicationProcess.acceptApplication(musician11);
        applicationProcess.acceptApplication(musician12);
        applicationProcess.acceptApplication(musician13);


        applicationProcess.processApplications();

        System.out.println("\nAccepted musicians:");
        applicationProcess.printMusiciansTable(applicationProcess.getSortedAcceptedMusicians());


        System.out.println("\nRejected musicians:");
        applicationProcess.printMusiciansTable(new ArrayList<>(applicationProcess.getRejectedApplications()));


        System.out.println("\nGenres count:");
        System.out.println(applicationProcess.countMusicianGenres());

        System.out.println("\nPop genre count:");
        System.out.println(applicationProcess.countGenreApplications("Pop"));

        System.out.println("\nGenre histogram:");
        applicationProcess.printGenreHistogram(applicationProcess.getGenreHistogram());
    }
}

