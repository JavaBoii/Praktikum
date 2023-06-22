package zettel_7.aufgabe2;

import java.util.*;

public class ApplicationProcess {
    private Queue<Musician> applications;
    private Set<Musician> acceptedMusicians;
    private Set<Musician> rejectedMusicians;
    private Map<String, Integer> genreCount;

    public ApplicationProcess() {
        applications = new LinkedList<>();
        acceptedMusicians = new HashSet<>();
        rejectedMusicians = new HashSet<>();
        genreCount = new HashMap<>();
    }

    public void acceptApplication(Musician musician) {
        applications.add(musician);
    }

    public void processApplications() {
        while (!applications.isEmpty()) {
            Musician musician = applications.poll();
            if (musician.getPerformances() <= 3 && !isGenreFull(musician.getGenres())) {
                acceptedMusicians.add(musician);
                addGenreCount(musician.getGenres());
            } else {
                rejectedMusicians.add(musician);
            }
        }
    }

    public Set<Musician> getRejectedApplications() {
        return Collections.unmodifiableSet(rejectedMusicians);
    }

    public List<Musician> getSortedAcceptedMusicians() {
        List<Musician> sortedMusicians = new ArrayList<>(acceptedMusicians);
        sortedMusicians.sort(Comparator.comparingInt(Musician::getPerformances));
        return sortedMusicians;
    }

    public Map<String, Integer> countMusicianGenres() {
        Map<String, Integer> genreCount = new HashMap<>();
        for (Musician musician : acceptedMusicians) {
            for (String genre : musician.getGenres()) {
                genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
            }
        }
        return genreCount;
    }

    public int countGenreApplications(String genre) {
        int count = 0;
        for (Musician musician : applications) {
            if (musician.getGenres().contains(genre)) {
                count++;
            }
        }
        return count;
    }

    public Map<String, Integer> getGenreHistogram() {
        return new HashMap<>(genreCount);
    }

    private boolean isGenreFull(Set<String> genres) {
        for (String genre : genres) {
            if (genreCount.getOrDefault(genre, 0) >= 2) {
                return true;
            }
        }
        return false;
    }

    private void addGenreCount(Set<String> genres) {
        for (String genre : genres) {
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
        }
    }

    public void printMusiciansTable(List<Musician> musicians) {
        System.out.printf("%-15s %-15s %-15s\n", "Name", "Performances", "Genres");
        for (Musician musician : musicians) {
            System.out.printf("%-15s %-15d %-15s\n",
                    musician.getName(),
                    musician.getPerformances(),
                    String.join(", ", musician.getGenres()));
        }
    }

    public void printGenreHistogram(Map<String, Integer> histogram) {
        System.out.printf("%-15s %s\n", "Genre", "Count");
        for (Map.Entry<String, Integer> entry : histogram.entrySet()) {
            System.out.printf("%-15s ", entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
