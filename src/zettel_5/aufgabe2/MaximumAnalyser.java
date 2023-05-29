package zettel_5.aufgabe2;

public class MaximumAnalyser extends AbstractNumberAnalyser {
    public MaximumAnalyser(String statisticName, double[] numbers) {
        super(statisticName, numbers);
    }

    public Double computeStatistic() {
        double max = super.getNumbers()[0];
        for (double number : super.getNumbers()) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}