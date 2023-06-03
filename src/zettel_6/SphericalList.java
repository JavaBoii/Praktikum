package zettel_6;

import java.util.*;

public class SphericalList<T, P extends Number> {
    private Point<P> center;
    private List<SphericalElement<T, P>> list;

    public SphericalList(Point<P> center) {
        this.center = center;
        this.list = new ArrayList<>();
    }

    public void add(SphericalElement<T, P> element) {
        list.add(element);
    }

    public List<T> getElementsWithinRadius(double radius) {
        List<T> result = new ArrayList<>();
        for (SphericalElement<T, P> element : list) {
            if (center.distanceTo(element.getPoint()) <= radius) {
                result.add(element.getItem());
            }
        }
        return result;
    }

    public void printInsideOut() {
        list.sort((el1, el2) -> Double.compare(center.distanceTo(el1.getPoint()),
                center.distanceTo(el2.getPoint())));
        for (SphericalElement<T, P> element : list) {
            System.out.println("- distance of " + element.getItem()
                    + " to center: " + String.format("%.6f", center.distanceTo(element.getPoint())));
        }
    }
}
