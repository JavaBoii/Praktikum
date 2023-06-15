package zettel_5.aufgabe2;

import styl.Styling;

public class Main {
    public static void separator(int length) {
        System.out.print("\n#");
        for (int i = 0; i < length - 2; i++) {
            System.out.print("----");
        }
        System.out.println("#\n");
    }
    public static void main(String[] args) {
        double[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double threshold = 5.0;

        AverageAnalyser averageAnalyzer_1 = new AverageAnalyser("Durchschnitt:", numbers);
        BelowThresholdAnalyser belowThresholdAnalyser_1 = new BelowThresholdAnalyser("Unter Schwellenwert von( " + threshold + " ): ", numbers, threshold);
        MaximumAnalyser maximumAnalyser_1 = new MaximumAnalyser("Maximum", numbers);

        averageAnalyzer_1.printStatistic();
        System.out.println();
        belowThresholdAnalyser_1.printStatistic();
        System.out.println();
        maximumAnalyser_1.printStatistic();

        separator(20);

        System.out.println(Styling.YELLOW + "\nStatistik Name von belowThresholdAnalyser_1: " + Styling.RESET + belowThresholdAnalyser_1.getStatisticName());
        belowThresholdAnalyser_1.setStatisticName(Styling.CYAN + "Neuer Name der Schwellenwert Statistik" + Styling.RESET);
        System.out.println(Styling.YELLOW + "Neuer Statistik Name von belowThresholdAnalyser_1: " + Styling.RESET + belowThresholdAnalyser_1.getStatisticName());

        separator(20);

        System.out.println(Styling.YELLOW + "Eingestellter Schwellenwert: " + Styling.RESET + belowThresholdAnalyser_1.getThreshold());
        belowThresholdAnalyser_1.setThreshold(10.0);
        System.out.println(Styling.YELLOW + "Neuer Schwellenwert: " + Styling.RESET + belowThresholdAnalyser_1.getThreshold());
        belowThresholdAnalyser_1.printStatistic();

        separator(20);

        System.out.println(Styling.YELLOW + "Eingestellte Zahlen: " + Styling.RESET);
        for (double number : belowThresholdAnalyser_1.getNumbers()) {
            System.out.print(number + " ");
        }
        belowThresholdAnalyser_1.setNumbers(new double[]{2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(Styling.YELLOW + "\nNeue Zahlen: " + Styling.RESET);
        for (double number : belowThresholdAnalyser_1.getNumbers()) {
            System.out.print(number + " ");
        }

        separator(20);

    }
}
