package assignment;

import java.util.ArrayList;
import java.util.List;

public class ShapeList {

    private List<Shape> list = new ArrayList<>();

    public void addShape(Shape object) {
        if (list.contains(object)) {
            System.out.println("Duplicate Object -->" + object);
        } else {
            list.add(object);
        }
    }

    public double sumPerimeter() {
        double sum = 0;
        for (Shape element : list) {
            sum += element.calculatePerimeter();
        }
        return sum;
    }

    public double sumSurface() {
        double sum = 0;
        for (Shape element : list) {
            sum += element.calculateSurface();
        }
        return sum;
    }

    public String getObject(int index) {
        return list.get(index).toString();
    }

    public double getObjectPerimeter(int index) {
        return list.get(index).calculatePerimeter();
    }

    public double getObjectSurface(int index) {
        return list.get(index).calculateSurface();
    }

}
