package assignment;

public class Square implements Shape {
    private int length;

    Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * length;
    }

    @Override
    public double calculateSurface() {
        return length * length;
    }

    @Override
    public String toString() {
        return "Square has the length equal with " + length;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Square && ((Square) obj).length == this.length;
    }
}
