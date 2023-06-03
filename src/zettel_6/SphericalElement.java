package zettel_6;

public class SphericalElement<T, P extends Number> {
    private T item;
    private Point<P> point;

    public SphericalElement(T item, Point<P> point) {
        this.item = item;
        this.point = point;
    }

    public T getItem() {
        return item;
    }

    public Point<P> getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "SphericalElement(" + item + ", " + point + ")";
    }
}
