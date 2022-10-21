package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (anotherArea > getArea()) {
            return -1;
        } else if (anotherArea < getArea()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        String result = floorCount + " этажный коттедж площадью " + getArea() + " метров";
        return result;
    }
}
// END
