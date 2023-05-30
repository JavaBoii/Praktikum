package zettel_5.aufgabe2;

public abstract class AbstractNumberAnalyser {
    private String statisticName;
    private double[] numbers;

    public AbstractNumberAnalyser(String statisticName, double[] numbers) {
        this.statisticName = statisticName;
        this.numbers = numbers;
    }

    public abstract Double computeStatistic();

    public void printStatistic() {
        System.out.println(Styling.YELLOW + "Name der Statistik: " + Styling.RESET + statisticName);
        System.out.print(Styling.YELLOW + "Nummern: " + Styling.RESET);
        for (double number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println(Styling.YELLOW + "\nStatistik: " + Styling.RESET + computeStatistic());
    }

    public String getStatisticName() {
        return statisticName;
    }

    public void setStatisticName(String statisticName) {
        this.statisticName = statisticName;
    }

    public double[] getNumbers() {
        return numbers;
    }

    public void setNumbers(double[] numbers) {
        this.numbers = numbers;
    }
}