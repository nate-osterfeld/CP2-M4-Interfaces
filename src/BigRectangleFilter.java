public class BigRectangleFilter implements Filter {
    double width;
    double height;
    int ID;

    public BigRectangleFilter(double width, double height, int ID) {
        this.width = width;
        this.height = height;
        this.ID = ID;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getID() {
        return ID;
    }

    public double getPerimeter() {
        return 2*(width + height);
    }

    @Override
    public boolean accept(Object x) {
        double perimeter = 2*(width + height);

        return perimeter > 10;
    }
}
