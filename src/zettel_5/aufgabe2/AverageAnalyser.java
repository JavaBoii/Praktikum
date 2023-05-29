package zettel_5.aufgabe2;

public class AverageAnalyser extends AbstractNumberAnalyser {
    public AverageAnalyser(String statisticName, double[] numbers) {
        super(statisticName, numbers);
    }

    public Double computeStatistic() {
        double sum = 0;
        for (double number : super.getNumbers()) {
            sum += number;
        }
        return sum / super.getNumbers().length;
    }
}