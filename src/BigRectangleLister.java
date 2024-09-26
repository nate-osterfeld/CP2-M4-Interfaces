import java.util.ArrayList;

public class BigRectangleLister {
    public static void main(String[] args) {
        ArrayList<BigRectangleFilter> rectangles = new ArrayList<>();

        // Rectangles with perimeter less than 10
        rectangles.add(new BigRectangleFilter(1, 1, 111)); // 4
        rectangles.add(new BigRectangleFilter(1, 2, 222)); // 6
        rectangles.add(new BigRectangleFilter(1, 3, 333)); // 8
        rectangles.add(new BigRectangleFilter(2, 1, 444)); // 6
        rectangles.add(new BigRectangleFilter(2, 2, 555)); // 8

        // Rectangles with perimeter greater than 10
        rectangles.add(new BigRectangleFilter(2, 4, 666)); // 12
        rectangles.add(new BigRectangleFilter(2, 5, 777)); // 14
        rectangles.add(new BigRectangleFilter(3, 4, 888)); // 14
        rectangles.add(new BigRectangleFilter(3, 5, 999)); // 16
        rectangles.add(new BigRectangleFilter(3, 6, 1000)); // 18

        System.out.println("Rectangles with a perimeter larger than 10:");
        for (BigRectangleFilter rectangle: rectangles) {
            if (rectangle.accept(rectangle)) {
                System.out.println(rectangle.getPerimeter());
            }
        }
    }
}
