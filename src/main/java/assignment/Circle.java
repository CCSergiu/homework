package assignment;

public class Circle implements Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int length) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double calculateSurface() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle has the radius equal with " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Circle && ((Circle) obj).radius == this.radius;
    }
}
