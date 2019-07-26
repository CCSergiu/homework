package assignment;


public class Rectangle implements Shape {
    private int width;
    private int length;

    Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * width + 2 * length;
    }

    @Override
    public double calculateSurface() {
        return width * length;
    }

    @Override
    public String toString() {
        return "Rectangle has the length equal with " + length + "and the width equal with " + width;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Rectangle && ((Rectangle) obj).length == this.length && ((Rectangle) obj).width == this.width;
    }

}
