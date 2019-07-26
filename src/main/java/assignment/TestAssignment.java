package assignment;


public class TestAssignment {
    public static void main(String[] args) {

        ShapeList list = new ShapeList();

        list.addShape(new Square(3));
        list.addShape(new Rectangle(3, 4));
        list.addShape(new Circle(2));
        list.addShape(new Triangle(3, 4, 5));

        System.out.println("Details of the list elements: ");

        System.out.println(list.getObject(0));
        System.out.println(list.getObjectPerimeter(0));
        System.out.println(list.getObjectSurface(0));

        System.out.println(list.getObject(1));
        System.out.println(list.getObjectPerimeter(1));
        System.out.println(list.getObjectSurface(1));

        System.out.println(list.getObject(2));
        System.out.println(list.getObjectPerimeter(2));
        System.out.println(list.getObjectSurface(2));

        System.out.println(list.getObject(3));
        System.out.println(list.getObjectPerimeter(3));
        System.out.println(list.getObjectSurface(3));

        System.out.println("Total sum of perimeter and surface are the following: ");
        System.out.println(list.sumPerimeter());
        System.out.println(list.sumSurface());

        System.out.println("Adding new object");
        list.addShape(new Square(3));


    }
}
