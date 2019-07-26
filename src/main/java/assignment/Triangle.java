package assignment;

public class Triangle implements Shape {
    int l1;
    int l2;
    int l3;

    Triangle(int l1, int l2, int l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public int getL1() {
        return l1;
    }

    public void setL1(int l1) {
        this.l1 = l1;
    }

    public int getL2() {
        return l2;
    }

    public void setL2(int l2) {
        this.l2 = l2;
    }

    public int getL3() {
        return l3;
    }

    public void setL3(int l3) {
        this.l3 = l3;
    }

    @Override
    public double calculatePerimeter() {
        return l1 + l2 + l3;
    }

    @Override
    public double calculateSurface() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
    }

    @Override
    public String toString() {
        return "Triangle has the lengths equal with " + l1 + ", " + l2 + ", " + l3;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Triangle && ((Triangle) obj).l1 == this.l1 && ((Triangle) obj).l2 == this.l2
                && ((Triangle) obj).l3 == this.l3;
    }
}
