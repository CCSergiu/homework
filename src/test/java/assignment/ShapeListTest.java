package assignment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShapeListTest {

    private ShapeList list = new ShapeList();

    @Test
    public void addShapeTest() {
        list.addShape(new Square(3));
        assertEquals(1, list.getSize());
    }

    @Test //pt fiecare metoda cu @Test se creaza o noua instanta din clasa de test (CalculatorTest)
    public void sumPerimeterTest() {
        list.addShape(new Square(3));
        list.addShape(new Rectangle(3, 4));
        list.addShape(new Circle(2));
        list.addShape(new Triangle(3, 4, 5));
        double sum = list.sumPerimeter();
        assertEquals(50.56637061435917, sum, 0.5);
    }

}