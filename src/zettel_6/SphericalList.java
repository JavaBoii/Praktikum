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
        List<SphericalElement<T, P>> copyList = new ArrayList<>(list);

        while (!copyList.isEmpty()) {
            SphericalElement<T, P> closest = null;
            double closestDistance = Double.MAX_VALUE;

            for (SphericalElement<T, P> element : copyList) {
                double distance = center.distanceTo(element.getPoint());
                if (distance < closestDistance) {
                    closest = element;
                    closestDistance = distance;
                }
            }

            System.out.println("- distance of " + closest.getItem()
                    + " to center: " + String.format("%.6f", closestDistance));

            copyList.remove(closest);
        }
    }


}
