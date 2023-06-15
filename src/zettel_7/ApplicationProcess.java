package zettel_7;

import java.util.*;

public class ApplicationProcess {
    private Queue<Musician> applications;
    private List<Musician> receivedApplications;
    private Set<Musician> accepted;
    private Set<Musician> rejected;
    private Map<String, Integer> genreCount;

    public ApplicationProcess() {
        this.applications = new LinkedList<>();
        this.receivedApplications = new ArrayList<>();
        this.accepted = new HashSet<>();
        this.rejected = new HashSet<>();
        this.genreCount = new HashMap<>();
    }

    public void apply(Musician musician) {
        this.applications.add(musician);
        this.receivedApplications.add(musician);
    }

    public void processApplications() {
        while (!applications.isEmpty()) {
            Musician musician = applications.poll();
            if (musician.getPerformances() > 3) {
                rejected.add(musician);
                continue;
            }
            boolean genreOverrepresented = false;
            for (String genre : musician.getGenres()) {
                int count = genreCount.getOrDefault(genre, 0);
                if (count >= 2) {
                    genreOverrepresented = true;
                    break;
                }
                genreCount.put(genre, count + 1);
            }
            if (genreOverrepresented) {
                rejected.add(musician);
            } else {
                accepted.add(musician);
            }
        }
    }

    public Set<Musician> getRejectedApplications() {
        return new HashSet<>(rejected);
    }

    public List<Musician> getAcceptedMusiciansByPerformances() {
        List<Musician> sortedMusicians = new ArrayList<>(accepted);
        sortedMusicians.sort(Comparator.comparingInt(Musician::getPerformances));
        return sortedMusicians;
    }

    public int[] getApplicationStatus() {
        return new int[]{applications.size(), accepted.size()};
    }

    public Map<String, Integer> getAcceptedGenres() {
        Map<String, Integer> genres = new HashMap<>();
        for (Musician musician : accepted) {
            for (String genre : musician.getGenres()) {
                int count = genres.getOrDefault(genre, 0);
                genres.put(genre, count + 1);
            }
        }
        return genres;
    }

    public int countApplicationsOfGenre(String genre) {
        int count = 0;
        for (Musician musician : applications) {
            if (musician.getGenres().contains(genre)) {
                count++;
            }
        }
        return count;
    }

    public Map<String, Integer> createGenreHistogram() {
        Map<String, Integer> histogram = new HashMap<>();
        for (Musician musician : receivedApplications) {
            for (String genre : musician.getGenres()) {
                int count = histogram.getOrDefault(genre, 0);
                histogram.put(genre, count + 1);
            }
        }
        return histogram;
    }
}
