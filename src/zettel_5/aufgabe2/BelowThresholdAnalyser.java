package zettel_5.aufgabe2;

public class BelowThresholdAnalyser extends AbstractNumberAnalyser {
    private double threshold;

    public BelowThresholdAnalyser(String statisticName, double[] numbers, double threshold) {
        super(statisticName, numbers);
        this.threshold = threshold;
    }

    public Double computeStatistic() {
        int count = 0;
        for (double number : super.getNumbers()) {
            if (number < threshold) {
                count++;
            }
        }
        return (double) count;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}