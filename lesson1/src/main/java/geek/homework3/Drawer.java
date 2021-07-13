package geek.homework3;

import java.util.Arrays;

public class Drawer {


    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {new Triangle(), new Circle(), new Square()};

        for (Shape shape : shapes) {
            shape.draw();
        }

        Arrays.stream(shapes).forEach(t -> t.draw());
        Arrays.stream(shapes).forEach(Shape::draw);
    }
}
