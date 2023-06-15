package zettel_6;

public class Point<T extends Number> {
    private T x, y, z;

    public Point(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(Point<T> other) {
        return Math.sqrt(Math.pow(this.x.doubleValue() - other.x.doubleValue(), 2)
                + Math.pow(this.y.doubleValue() - other.y.doubleValue(), 2)
                + Math.pow(this.z.doubleValue() - other.z.doubleValue(), 2));
        //D = sqrt( (x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2 )
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ", " + z + ")";
    }
}
