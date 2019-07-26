package assignment;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ShapeListTest {

    private ShapeList list = new ShapeList();

    @Before
    public void setup() {
        //initialize resources before every test
        list.addShape(new Square(3));
        list.addShape(new Rectangle(3, 4));
        list.addShape(new Circle(2));
        list.addShape(new Triangle(3, 4, 5));
    }

    @BeforeClass
    public void setupClass() {
        //initialize resources before all tests
        //populate database with test data
    }

    @After
    public void after() {

    }

    @AfterClass
    public void afterClass() {
        //repo.deleteAllObjects();
    }

    @Test //pt fiecare metoda cu @Test se creaza o noua instanta din clasa de test (CalculatorTest)
    public void sumPerimeterTest() {
        double sum = list.sumPerimeter();
        assertEquals(50.56637061435917, sum, 0.5);
    }

    public void sumSurfaceTest() {
        double sum = list.sumSurface();
        assertEquals(39.56637061435917, sum, 0.5);
    }
}