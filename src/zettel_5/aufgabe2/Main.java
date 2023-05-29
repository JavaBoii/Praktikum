package zettel_5.aufgabe2;

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

        AverageAnalyser aA = new AverageAnalyser("Durchschnitt:", numbers);
        BelowThresholdAnalyser bta = new BelowThresholdAnalyser("Unter Schwellenwert von( " + threshold + " ): ", numbers, threshold);
        MaximumAnalyser mA = new MaximumAnalyser("Maximum", numbers);

        aA.printStatistic();
        System.out.println();
        bta.printStatistic();
        System.out.println();
        mA.printStatistic();

        separator(20);

        System.out.println(Styling.YELLOW + "\nStatistik Name von bta: " + Styling.RESET + bta.getStatisticName());
        bta.setStatisticName(Styling.CYAN + "Neuer Name der Schwellenwert Statistik" + Styling.RESET);
        System.out.println(Styling.YELLOW + "Neuer Statistik Name von bta: " + Styling.RESET + bta.getStatisticName());

        separator(20);

        System.out.println(Styling.YELLOW + "Eingestellter Schwellenwert: " + Styling.RESET + bta.getThreshold());
        bta.setThreshold(10.0);
        System.out.println(Styling.YELLOW + "Neuer Schwellenwert: " + Styling.RESET + bta.getThreshold());
        bta.printStatistic();

        separator(20);

        System.out.println(Styling.YELLOW + "Eingestellte Zahlen: " + Styling.RESET);
        for (double number : bta.getNumbers()) {
            System.out.print(number + " ");
        }
        bta.setNumbers(new double[]{2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(Styling.YELLOW + "\nNeue Zahlen: " + Styling.RESET);
        for (double number : bta.getNumbers()) {
            System.out.print(number + " ");
        }

        separator(20);

    }
}
